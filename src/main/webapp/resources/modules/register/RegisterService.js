'use strict';

angular.module('register')

.factory('RegisterService',
		['$http', '$cookieStore', '$rootScope', '$timeout',
		 function($http, $cookieStore, $rootScope, $timeout) {
			var service = {};

			service.register = function(user,callback) {
				//Server call

				var userData = JSON.stringify(user);
				$http.post('http://blrlw3450.asia.manh.com:8080/security/register',userData)
				.success(function(response) {
					callback(response);
				});

			};
			return service;
		}]);