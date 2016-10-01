var TigairApp = angular.module('TigairApp', ['TigairApp.controllers', 'TigairApp.detailsController', 'TigairApp.services', 'pascalprecht.translate', 'ui.router']);

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
        });
        
});