var app = angular.module("myApp");
app.controller('checkoutController', function ($scope, $http,$location,$rootScope){
	 $scope.detailsOfCheckedInUser=[];
       $scope.getCheckedInDetails=function(){
       	 $http.get("http://localhost:8080/getCheckedInDetails").then(function(response){
            console.log(response);
            $scope.detailsOfCheckedInUser=response.data;
            console.log($scope.detailsOfCheckedInUser);

        })
       }
       $scope.getCheckedInDetails();

        $scope.checkout=function(bookingId,roomNumber){
        	var details={
               "bookingId": bookingId,
             "roomNumber": roomNumber
             }

        	 $http.post("http://localhost:8080/checkout",details).then(function(response){
        	 	console.log(response);
        	 	 swal("Thanks", response.data.responseValue , "success");
        	 	 console.log(response.responseValue);
        	 	 $scope.getCheckedInDetails();
             $scope.billviewStatus=true;

        	})
        }
        
$scope.printDiv = function(div) {
  var printContents = document.getElementById(div).innerHTML;
  var popupWin = window.open('', 'width=700,height=300');
  popupWin.document.open();
  popupWin.document.write('<html><head><link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"><link rel="stylesheet" type="text/css" href="./css/global.css" /></head><body onload="window.print()">' + printContents + '</body></html>');
  popupWin.document.close();
} 
$scope.billDetails={};
$scope.billviewStatus=false;


$scope.generateBill=function(detail){
  $scope.billDetails=detail;
  $scope.billDetails.checkOutDate=new Date();
  $scope.billDetails.noOfDays=Math.round((new Date()-new Date($scope.billDetails.checkInDate))/ (1000 * 60 * 60 * 24));
  $scope.billDetails.discount=5;
  $scope.billDetails.gst=18;
  //total after discount
  var total=($scope.billDetails.price* $scope.billDetails.noOfDays)-
  (($scope.billDetails.price* $scope.billDetails.noOfDays)/100*$scope.billDetails.discount)
  //total after gst
  $scope.billDetails.total=(total/100*$scope.billDetails.gst)+total;

  $scope.billviewStatus=true;
 // $scope.printDiv('billview');
}
})