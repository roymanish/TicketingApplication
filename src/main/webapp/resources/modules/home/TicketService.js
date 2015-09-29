'use strict';

angular.module('home')

.factory('TicketService',
		['$http', '$cookieStore', '$rootScope', '$timeout',
		 function($http, $cookieStore, $rootScope, $timeout) {
			var service = {};

			service.loadAllTickets = function(callback) {

				//Server call

				$http.get('http://localhost:8080/security/getAll')
				.success(function(response) {
					callback(response);
				});

			};

			service.createTicket = function(ticket,callback) {

				$http.defaults.headers.common['Accept'] = 'application/json';
				$http.defaults.headers.common['Content-Type'] = 'application/json';
				//Server call
				$http.post('http://localhost:8080/security/create',ticket)
				.success(function(response) {
					callback(response);
				});

			};
			service.updateTicket = function(ticket,callback) {

				$http.defaults.headers.common['Accept'] = 'application/json';
				$http.defaults.headers.common['Content-Type'] = 'application/json';
				//Server call
				$http.post('http://localhost:8080/security/update',ticket)
				.success(function(response) {
					callback(response);
				});

			};
			
			service.logout = function(callback) {
                
                $http.post('http://localhost:8080/security/j_spring_security_logout')
                 .success(function(response) {
                 callback(response);
                 });
            };

			return service;
		}]);