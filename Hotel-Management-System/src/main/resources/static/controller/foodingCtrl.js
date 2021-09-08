var app = angular.module("myApp");
app.controller("foodingController", function($scope, $http, $location, $rootScope) {
    $scope.nonvegList = [];
    $scope.vegList = [];
    $scope.recipeList = [];
    /* jquery for section scroll*/
   /* $(function() {
        $('nav a').click(function(e) {
            e.preventDefault();
            $('body, html').animate({
                scrollTop: $($.attr(this, 'href')).offset().top
            }, 750);
        });
    });*/
    $scope.getAllFoodDetails = function() {
        $http.get("http://localhost:8080/getAllFoodDetails").then(function(response) {
            $scope.recipeList = response.data;
        })
    }
    $scope.getVegFoodDetailsByCategory = function() {
    	$scope.foodcategory="VEG";
        $http.post("http://localhost:8080/getAllFoodDetailsByCategory",$scope.foodcategory).then(function(response) {
            $scope.vegList = response.data;
        })

    }
     $scope.getVegFoodDetailsByCategory();
     $scope.getNonvegFoodDetailsByCategory = function() {
    	$scope.foodcategory="NON-VEG";
        $http.post("http://localhost:8080/getAllFoodDetailsByCategory",$scope.foodcategory).then(function(response) {
            $scope.nonvegList = response.data;
        })

    }
 $scope.getNonvegFoodDetailsByCategory();
    $scope.addNewRecipe = function() {
    	$scope.food.itemId=0;
        $scope.food.status = true;
        $http.post("http://localhost:8080/saveFoodItem", $scope.food).then(function(response) {
            if (response.status == 200 && response.data != "") {
                swal("Success", "Item added Sucessfully", "success");
                  $scope.getVegFoodDetailsByCategory();
                   $scope.getNonvegFoodDetailsByCategory();
            } else {
                swal("Sorry", "invalid data", "error");
            }

        })

    }

});