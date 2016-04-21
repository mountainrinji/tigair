
angular.module('TigairApp.controllers', ['TigairApp.services']).
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
    
    activitiesService.getAircraftData('SP-DTQ').success(function (response) {
    	$scope.aircraftData = response;
    });
    
    activitiesService.getAircraftActivitiesExecution('A', 'MAINT').success(function (response) {
    	
    	$scope.aircraftActivitiesExecutionAMAINT = response;
    });
    
});