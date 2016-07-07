
angular.module('TigairApp.controllers', ['TigairApp.services', ]).
controller('indexController', function($scope, activitiesService, $translate) {
	
	$translate.use('pl');
	
    $scope.appVersion = "0.01";
    
    $scope.activitiesStatus = "";
    $scope.javaActivitiesStatus = "";
    $scope.aircraftData = {};
    $scope.currentDate = new Date();
    
    $scope.aircraftActivitiesExecutionAMAINT = {};
    $scope.aircraftActivitiesExecutionEMAINT = {};
    $scope.aircraftActivitiesExecutionPMAINT = {};
    $scope.aircraftActivitiesExecutionASBAD = {};
    $scope.aircraftActivitiesExecutionESBAD = {};
    $scope.aircraftActivitiesExecutionPSBAD = {};
    $scope.aircraftActivitiesExecutionACOMP = {};
    $scope.aircraftActivitiesExecutionECOMP = {};
    $scope.aircraftActivitiesExecutionPCOMP = {};
    
    $scope.activitiesStatus = activitiesService.getActivitiesStatus();
    
    activitiesService.getJavaActivitiesStatus().success(function(response) {
    	$scope.javaActivitiesStatus = response;
    });
    
    activitiesService.getAircraftData("PH-USA").success(function (response) {
    	$scope.aircraftData = response;
    });
    
    activitiesService.getAircraftActivitiesExecution("PH-USA", 'A', 'MAINT').success(function (response) {
    	
    	$scope.aircraftActivitiesExecutionAMAINT = response;
    });
    
    activitiesService.getAircraftActivitiesExecution("PH-USA", 'E', 'MAINT').success(function (response) {
    	
    	$scope.aircraftActivitiesExecutionEMAINT = response;
    });

    activitiesService.getAircraftActivitiesExecution("PH-USA", 'P', 'MAINT').success(function (response) {
	
	$scope.aircraftActivitiesExecutionPMAINT = response;
});
    
});