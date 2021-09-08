var app = angular.module("myApp");
app.controller('loginController', function($scope, $http, $location, $rootScope) {

    $scope.emailid = 'me@example.com';
    $scope.password = '';
   /* $scope.hidediv = true;
    $scope.loginhide = function() {
        if ($scope.hidediv == false) {
            $scope.hidediv = true;
        } else {
            $scope.hidediv = false;
        }
    }*/

    $scope.login = function() {
        $scope.logindetails = {
            "mailid": $scope.emailid,
            "password": $scope.password
        };

        $http.post("http://localhost:8080/validateLogin", $scope.logindetails).then(function(response) {
            console.log(response);
            if (response.status == 200 && response.data != "") {
                $rootScope.user = response.data;
                $location.path("/checkout");
                swal("Welcome Back!" + response.data.name, "You are authenticated", "success");
            } else {
                swal("Sorry", "You are not authenticated...", "error");
            }
        });
    }
    $scope.saveuser = function() {
        console.log($scope.user);
        $scope.user.id = 0;
        $http.post("http://localhost:8080/saveUser", $scope.user).then(function(response) {
            $location.path("/");
            swal("Good Job!", "Successfully Registered", "success");
        });
    }

    $scope.getForm=function(form){
        console.log(form.emailid);
    }

});