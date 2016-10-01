TigairApp.directive('activitiesExecutionTable', function (selectionService, $location) {
    return {
        restrict: 'E',
        transclude: true,
		scope: {
			headerCss: '=',
			partDataVisibilityCss: '=',
			aircraftActivitiesExecution: '=',
			part: '=',
			partData: '='
		},
	    templateUrl: '/tigair/content/components/activities_execution_table.html',
	    controller: function ($scope, selectionService) {
	    	$scope.go = function($item) {
	    		selectionService.set($item);
	    		alert(selectionService.get());
	    		 $location.url('details.html');
	    		};	
	    }
	};
});
