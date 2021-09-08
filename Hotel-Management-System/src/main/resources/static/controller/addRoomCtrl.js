var app = angular.module("myApp");
app.controller("addRoomController", function($scope,$http,$location,$rootScope) {
	$scope.room={};
	$scope.floor=1;
	 $scope.roomdetails=[];
	$scope.getNewRoomNumber=function(){
		 $http.post("http://localhost:8080/getNewRoomNumber", $scope.floor).then(function(response) {
            if (response) {
            	console.log(response);
                $scope.room.roomnumber = response.data;
                $scope.room.status=true;
                
            } else {
                swal("Sorry", "Your booking failed", "error");
            }

        })

	}
$scope.getNewRoomNumber();
	$scope.addRoom=function(){
		 $http.post("http://localhost:8080/addRoom", $scope.room).then(function(response) {
            if (response) {
            	console.log(response);
                 swal("Welcome", "Room added Sucessfully", "success");
                  $scope.getAllRoomDetails();
                
            } else {
                swal("Sorry", "Your booking failed", "error");
            }

        })

	}
	
	 $scope.getAllRoomDetails = function() {
       
        $http.get("http://localhost:8080/getAllRoomDetails").then(function(response) {
            if (response) {

                $scope.roomdetails = response.data;
                console.log(response);
            } else {
                swal("Sorry", "Your booking failed", "error");
            }

        })
    }
    $scope.getAllRoomDetails();
	
	
});