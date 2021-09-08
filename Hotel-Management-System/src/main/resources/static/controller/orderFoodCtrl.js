var app = angular.module("myApp");
app.controller("orderFoodController", function($scope, $http, $location, $rootScope) {

    $scope.roomdetails = [];
    $scope.detailsOfCheckedInUser = {};
    $scope.nonvegList = [];
    $scope.vegList = [];
    $scope.viewMenu = false;
    $scope.orderDetails = { items: [], roomNumber: 0, totalPrice: 0, customerId: 0 };

   /* $scope.addVegItem = function(veg) {
        $scope.vegItemDetails = veg;
        $scope.id = veg.itemId;
        $scope.count = 0;
        for (var i = 0; i <$scope.items.length; i++) {
            if ($scope.items[i].includes(id)) {
                return count = count + 1;
            } else {
                return count = 0;
            }
        }
        if(count=0){
        	 $scope.items.push($scope.vegItemDetails);
            console.log($scope.items);
        }
        /*if ($scope.items.includes(id)) {
            count = count + 1;
        } else {
            $scope.items.push($scope.vegItemDetails);
            console.log($scope.items);
        }*/
    }*/

    $scope.getAllRoomDetails = function() {
        $http.get("http://localhost:8080/getAllRoomDetails").then(function(response) {
            $scope.roomdetails = response.data;
        })
    }
    $scope.getAllRoomDetails();
    $scope.getCheckedInDetailsByRoomNo = function(roomnumber) {

        $scope.viewMenu = false;
        $scope.roomnumber = roomnumber;
        $http.post("http://localhost:8080/getCheckedInDetailsByRoomNo", $scope.roomnumber).then(function(response) {
            $scope.detailsOfCheckedInUser = response.data;
            $scope.viewMenu = true;
            $scope.orderDetails = { items: [], roomNumber: $scope.roomnumber, totalPrice: 0, customerId: $scope.detailsOfCheckedInUser.customerId };
        })
    }

    $scope.getVegFoodDetailsByCategory = function() {
        $scope.foodcategory = "VEG";
        $http.post("http://localhost:8080/getAllFoodDetailsByCategory", $scope.foodcategory).then(function(response) {
            $scope.vegList = response.data;
        })

    }
    $scope.getVegFoodDetailsByCategory();
    $scope.getNonvegFoodDetailsByCategory = function() {
        $scope.foodcategory = "NON-VEG";
        $http.post("http://localhost:8080/getAllFoodDetailsByCategory", $scope.foodcategory).then(function(response) {
            $scope.nonvegList = response.data;
        })

    }
    $scope.getNonvegFoodDetailsByCategory()
});