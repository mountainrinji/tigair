TigairApp.directive('activitiesExecutionTable', function () {
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
	    controller: function ($scope) {
	    	
	      }
	};
});
