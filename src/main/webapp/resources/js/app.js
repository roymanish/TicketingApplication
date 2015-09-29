'use strict';

/* App Module */
//declare modules
angular.module('login', []);
angular.module('home', []);
angular.module('register', []);
var ticketingApp = angular.module('TicketingApp', ['ngRoute', 'login','home','register','ngCookies']);

ticketingApp.config(['$routeProvider',
                     function($routeProvider) {
	$routeProvider.
	when('/login', {
		templateUrl: 'resources/modules/login/login.html',
		controller: 'LoginController'
	}).
	when('/home', {
		templateUrl: 'resources/modules/home/home.html',
		controller: 'TicketController'
	}).
	when('/register', {
		templateUrl: 'resources/modules/register/register.html',
		controller: 'RegisterController'
	}).
	when('/createticket', {
		templateUrl: 'resources/modules/home/createTicket.html',
		controller: 'TicketController'
	}).
	when('/updateticket', {
        templateUrl: 'resources/modules/home/updateTicket.html',
        controller: 'TicketController'
    }).
	otherwise({
		redirectTo: '/login'
	});
}]);
ticketingApp.factory("ConfigFactory",function($rootScope){

	return{
		getAssignTo: function(){
			var ref = JSON.parse('{"groups":["Maroy","RShekhar","ARahul","JPriya"]}');
			return ref;
		}
	}
});