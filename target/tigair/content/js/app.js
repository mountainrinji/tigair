var TigairApp = angular.module('TigairApp', ['TigairApp.controllers', 'TigairApp.detailsController', 'TigairApp.copyController', 'TigairApp.createController', 'TigairApp.services', 'pascalprecht.translate', 'ui.router', 'ngResource']);

TigairApp.config(function($stateProvider, $urlRouterProvider) {
    
    $urlRouterProvider.otherwise('/list');
    
    $stateProvider
        
        // HOME STATES AND NESTED VIEWS ========================================
        .state('list', {
            url: '/list',
            templateUrl: 'list.html',
            controller: 'indexController'
        })
        
        // ABOUT PAGE AND MULTIPLE NAMED VIEWS =================================
        .state('about', {
        	url: '/about',
            templateUrl: 'details.html',
            controller: 'detailsController'
        })
        
        // ABOUT PAGE AND MULTIPLE NAMED VIEWS =================================
        .state('copy', {
        	url: '/copy',
            templateUrl: 'copy.html',
            controller: 'copyController'
        })
    
 // ABOUT PAGE AND MULTIPLE NAMED VIEWS =================================
    .state('create', {
    	url: '/create',
        templateUrl: 'create.html',
        controller: 'createController'
    });
        
});