var app = angular.module("myApp");
app.controller('checkinController', function($scope, $http, $location, $rootScope) {
    $scope.checkinuser = {};
    $scope.selectedRoom = {};
    $scope.allocateRoomStatus = false;
    $scope.getSelectedRoomNumber = function(room) {
        $scope.selectedRoom = room;
        $scope.checkinuser.price=room.price;
        if (room.roomnumber) {
            $scope.allocateRoomStatus = true;
        }
    }
    $scope.allocateRoom = function() {
        $scope.checkinuser.roomNumber = $scope.selectedRoom.roomnumber;
        $scope.checkinuser.roomType = $scope.selectedRoom.roomtype;
        console.log($scope.selectedRoom);
        $http.post("http://localhost:8080/allocateRoom", $scope.checkinuser).then(function(response) {
            if (response.status == 200 && response.data != "") {
                $location.path("/checkout");
                swal("Welcome", "Booking Sucessful", "success");
            } else {
                swal("Sorry", "Your booking failed", "error");
            }

        })
    }
    $scope.getRoomDetails = function() {
        $scope.roomDetails = {
            "roomsize": $scope.checkinuser.bed,
            "roomtype": $scope.checkinuser.roomtype
        }
        $http.post("http://localhost:8080/getRoomDetails", $scope.roomDetails).then(function(response) {
            if (response) {
                $scope.roomdetails = response.data;
                console.log(response);
            } else {
                swal("Sorry", "Your booking failed", "error");
            }

        })
    }

})