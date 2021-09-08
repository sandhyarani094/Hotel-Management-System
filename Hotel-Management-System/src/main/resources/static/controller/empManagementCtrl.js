var app = angular.module("myApp");
app.controller("employeeController", function($scope,$http,$location,$rootScope) {
	 $scope.employeeList=[];
	 $scope.viewemp={};
	$scope.getAllEmployee=function(){
		 $http.get("http://localhost:8080/getAllEmployee").then(function(response){
            console.log(response);
            $scope.employeeList=response.data;
            
        })
	}
	$scope.getAllEmployee();
	$scope.showEmp=function(emp){
		$scope.viewemp=emp;
	}
	$scope.addEmployee=function(){
		$scope.employee.employmentStatus=true;
		console.log($scope.employee);
		 $http.post("http://localhost:8080/addEmployee", $scope.employee).then(function(response) {
            if (response.status == 200 && response.data != "") {
                swal("Success", "Employee added Sucessfully", "success");
                $scope.getAllEmployee();
            } else {
                swal("Sorry", "invalid data", "error");
            }

        })

	}
	$scope.reliveEmployee=function(empId){
		$http.post("http://localhost:8080/reliveEmployee", empId).then(function(response) {
            if (response.status == 200 && response.data != "") {
               
                swal("Success", "Employee removed Sucessfully", "success");
                $scope.getAllEmployee();
            } else {
                swal("Sorry", "Unable to process your request", "error");
            }

        })
		
	}
	$scope.sendRating=function() {
		
	}
});