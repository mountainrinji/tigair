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
	
	Object.defineProperty($scope, 'addedRecords', {
        get: function() { return selectionService.getAddedRecords(); }
        
    });
	
	
    $scope.copy = function () {
    	var copyObject = {
    		'addedRecords': $scope.addedRecords,
    		'source' : 'SP-FYZ',
    		'target' : 'SP-DTQ'
    	
    	};
       CopyFactory.copy(copyObject);
    };
    
	
});

angular.module('TigairApp.createController', ['TigairApp.services', ]).
controller('createController', function($scope, $state, CreateFactory, $translate) {
	$translate.use(urlParams['lang']);
	
    $scope.currentDate = new Date();
    $scope.newRecord = {};
    $scope.showSpecialInterval = false;
    
    $scope.activityTypes = [
    	{'label' : 'actionType_overhaul', 'value' : 'O'},	
    	{'label' : 'actionType_inspect', 'value' : 'I'},
    	{'label' : 'actionType_replace', 'value' : 'R'},
    	{'label' : 'actionType_lubricate', 'value' : 'L'},
    	{'label' : 'actionType_clean', 'value' : 'C'},
    	{'label' : 'actionType_oncondition', 'value' : 'S'},
    	{'label' : 'actionType_renew', 'value' : 'N'},
    	{'label' : 'actionType_test', 'value' : 'T'},
    	{'label' : 'actionType_escalate', 'value' : 'E'}
    ];
    
    $scope.activityParts = [
        {'label' : 'activityPart_A', 'value' : 'A'},
        {'label' : 'activityPart_E', 'value' : 'E'},
        {'label' : 'activityPart_P', 'value' : 'P'}
    ];
    
    $scope.createActivity = function () {
        CreateFactory.post($scope.newRecord);
     };
	
    
});
