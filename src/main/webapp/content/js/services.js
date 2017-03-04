
angular.module('TigairApp.services', ['ngResource']).
factory('activitiesService', function($http) {

    var activitiesServiceAPI = {};

    activitiesServiceAPI.getActivitiesStatus = function() {
      return "up to date";
    }
    
    activitiesServiceAPI.getJavaActivitiesStatus = function() {
        return $http({
            method: 'GET', 
            url: '/tigair/rest/genericFacade/getJavaActivitiesStatus',
            params: {activityId: "1"}
          });
      }
    
    activitiesServiceAPI.getAircraftActivitiesExecution = function(regmark, activityPart, activityType) {
        return $http({
            method: 'GET', 
            url: '/tigair/rest/genericFacade/getAircraftActivitiesExecution',
            params: {regmark: regmark, activityPart: activityPart, activityType : activityType}
          });
      }
    
    activitiesServiceAPI.getAircraftData = function(regmark) {
    	return $http({
    		method: 'GET',
    		url: '/tigair/rest/genericFacade/getAircraftData',
    		params: {regmark: regmark}
    	});
    }

    return activitiesServiceAPI;
  });

var services = angular.module('TigairApp.services');
services.service('selectionService', function() {

    var selectedRecord;
    
    function set(data) {
    	selectedRecord = data;
    }
    function get() {
    	  return selectedRecord;
    }
    
    return {
    	  set: set,
    	  get: get
    	 }
    
  });

/*services.factory('UserFactory', function ($resource) {
	
	var userFactoryAPI = {};
	
	userFactoryAPI.update = function () {	
		return $resource('/tigair/rest/genericFacade/save', {}, {
			update: { method: 'PUT', params: {id: '@id'} }
		});
	}
	
	return userFactoryAPI;
});*/

services.factory('UserFactory', function ($resource) {
    return $resource('/tigair/rest/genericFacade/save', {}, {
        update: { method: 'PUT', params: {id: '@id'} }
    })
});