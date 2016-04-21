
angular.module('TigairApp.services', []).
factory('activitiesService', function($http) {

    var activitiesServiceAPI = {};

    activitiesServiceAPI.getActivitiesStatus = function() {
      return "up to date";
    }
    
    activitiesServiceAPI.getJavaActivitiesStatus = function() {
        return $http({
            method: 'GET', 
            url: 'http://localhost:8080/tigair/rest/genericFacade/getJavaActivitiesStatus',
            params: {activityId: "1"}
          });
      }
    
    activitiesServiceAPI.getAircraftActivitiesExecution = function(activityPart, activityType) {
        return $http({
            method: 'GET', 
            url: 'http://localhost:8080/tigair/rest/genericFacade/getAircraftActivitiesExecution',
            params: {activityPart: activityPart, activityType : activityType}
          });
      }
    
    activitiesServiceAPI.getAircraftData = function(regmark) {
    	return $http({
    		method: 'GET',
    		url: 'http://localhost:8080/tigair/rest/genericFacade/getAircraftData',
    		params: {regmark: regmark}
    	});
    }

    return activitiesServiceAPI;
  });