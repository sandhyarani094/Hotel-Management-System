var app = angular.module('myApp', ["ngRoute"]);
app.config(function($routeProvider) {
    $routeProvider.when("/", {
        templateUrl: "./pages/login.html",
        controller: "loginController"
    }).when("/checkin", {
        templateUrl: "./pages/checkin.html",
        controller: "checkinController"
    }).when("/checkout", {
        templateUrl: "./pages/checkout.html",
        controller: "checkoutController"
    }).when("/empManagement", {
        templateUrl: "./pages/empManagement.html",
        controller: "employeeController"
    }).when("/addRoom", {
        templateUrl: "./pages/addRoom.html",
        controller: "addRoomController"
    }).when("/fooding", {
        templateUrl: "./pages/fooding.html",
        controller: "foodingController"
    }).when("/orderFood", {
        templateUrl: "./pages/orderFood.html",
        controller: "orderFoodController"
    });


});