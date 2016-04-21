app.directive('activitiesExecutionTable', function () {
    return {
        restrict: 'E',
        transclude: true,
		scope: {
			aircraftActivitiesExecution: '='
		},
	    templateUrl: '/tigair/content/components/activities_execution_table.html'
	};
});
