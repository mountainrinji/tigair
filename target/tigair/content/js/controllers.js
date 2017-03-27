var urlParams;
    (window.onpopstate = function () {
        var match,
            pl     = /\+/g,  // Regex for replacing addition symbol with a space
            search = /([^&=]+)=?([^&]*)/g,
            decode = function (s) { return decodeURIComponent(s.replace(pl, " ")); },
            query  = window.location.search.substring(1);

        urlParams = {};
        while (match = search.exec(query))
           urlParams[decode(match[1])] = decode(match[2]);
    })();
    
   


angular.module('TigairApp.controllers', ['TigairApp.services', ]).
controller('indexController', function($scope, $state, activitiesService, $translate) {
	
	
	$translate.use(urlParams['lang']);
	
    $scope.appVersion = "0.01";
    
    $scope.activitiesStatus = "";
    $scope.javaActivitiesStatus = "";
    $scope.aircraftData = {};
    $scope.currentDate = new Date();
    
    $scope.selectedRecord = {};
    
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
    
    activitiesService.getAircraftData(urlParams['regMark']).success(function (response) {
    	$scope.aircraftData = response;
    });
    
    activitiesService.getAircraftActivitiesExecution(urlParams['regMark'], 'A', 'MAINT').success(function (response) {
    	
    	$scope.aircraftActivitiesExecutionAMAINT = response;
    });
    
    activitiesService.getAircraftActivitiesExecution(urlParams['regMark'], 'E', 'MAINT').success(function (response) {
    	
    	$scope.aircraftActivitiesExecutionEMAINT = response;
    });

    activitiesService.getAircraftActivitiesExecution(urlParams['regMark'], 'P', 'MAINT').success(function (response) {
	
	$scope.aircraftActivitiesExecutionPMAINT = response;
	
	$scope.copy = function () {
		$state.go('copy');
	};
});
    
});

angular.module('TigairApp.detailsController', ['TigairApp.services', ]).
controller('detailsController', function($scope, selectionService, UserFactory, $translate) {
	//$scope.selectedRecord = selectionService.selectedRecord;
	
	Object.defineProperty($scope, 'selectedRecord', {
        get: function() { return selectionService.get(); }
        //set: function(val) { testService.count = val; },
    });
	
	// callback for ng-click 'updateUser':
    $scope.updateUser = function () {
       UserFactory.update($scope.selectedRecord);
    };
    
    $scope.test = function(clazz, method) {
    	UserFactory.test(clazz, method);
    };
	
});

angular.module('TigairApp.copyController', ['TigairApp.services', ]).
controller('copyController', function($scope, selectionService, CopyFactory, $translate) {
	//$scope.selectedRecord = selectionService.selectedRecord;
	
	Object.defineProperty($scope, 'addedRecords', {
        get: function() { return selectionService.getAddedRecords(); }
        //set: function(val) { testService.count = val; },
    });
	
	
    $scope.copy = function () {
    	var copyObject = {
    		'addedRecords': $scope.addedRecords,
    		'source' : 'SP-FYZ',
    		'target' : 'SP-DTQ'
    	
    	};
       CopyFactory.copy(copyObject);
    };
    
    /*$scope.test = function(clazz, method) {
    	UserFactory.test(clazz, method);
    };*/
	
});

//angular.module('TigairApp.controllers', ['TigairApp.services', ]).
//controller('detailsController', function($scope, $translate, selectionService) {
//    
//    alert('ad');
//    
//    
//});
