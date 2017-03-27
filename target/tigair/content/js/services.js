
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
    
    var addedRecords = [];
    var addedRecordsIds = [];
    
    function set(data) {
    	selectedRecord = data;
    }
    function get() {
    	  return selectedRecord;
    }
    
    function update(data) {
    	if (indexOf(data) >= 0) {
    		addedRecords.splice(indexOf(data), 1);
    		addedRecordsIds.splice(indexOf(data), 1);
    	} else {
    		addedRecords.push(data);
    		addedRecordsIds.push(data.aircraftActivityStatus.taskIdentifier);
    	}
    }
    
    function getAddedRecords() {
    	return addedRecords;
    }
    
    function indexOf(data) {
    	return addedRecordsIds.indexOf(data.aircraftActivityStatus.taskIdentifier);
    }
    
    return {
    	  set: set,
    	  get: get,
    	  update: update,
    	  getAddedRecords: getAddedRecords,
    	  indexOf: indexOf
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
    });
});


services.factory('CopyFactory', function ($resource) {
    return $resource('/tigair/rest/genericFacade/copy', {}, {
        copy: { method: 'PUT', params: {id: '@id'} }
    });
});