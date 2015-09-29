'use strict';

angular.module('home')

.controller('TicketController',
		['$scope', '$rootScope', '$location', 'TicketService','ConfigFactory','$filter',
		 function($scope, $rootScope, $location, TicketService,ConfigFactory,$filter) {

			$scope.assignToGroups = ConfigFactory.getAssignTo().groups;

			$scope.loadAllTickets = function() {
				$scope.dataLoading = true;

				if($rootScope.authenticated){
					TicketService.loadAllTickets(function(response) {

						if (response) {
							$scope.tickets = response;
							$rootScope.tickets = response;
							$scope.dataLoading = false;
						}
						else {
							$scope.error = response.message;
							$scope.dataLoading = false;
							$location.path('/login');
						}
					});
				}
				else{
					$location.path('/login');
				}
			};
			//$scope.tickets = $scope.loadAllTickets();
			$scope.createTicket = function() {
				$scope.dataLoading = true;
				var ticket = {"custName": $scope.custName, "email": $scope.email, "ticketSub": $scope.ticketSub, "assignedTo": $scope.assignedTo, "comments": $scope.comments, "createdBy": "Dummy User", "status": "Open"};
				if($rootScope.authenticated){
					TicketService.createTicket(ticket,function(response) {

						if (response) {
							$location.path('/home');
						}
						else {
							$scope.error = response.message;
							$scope.dataLoading = false;
						}
					});
				}
				else{
					$location.path('/login');
				}
			};
			$scope.updateTicket = function() {
				$scope.dataLoading = true;
				var ticket = {"id":$rootScope.ticket.id,"custName": $scope.custName, "email": $scope.email, "ticketSub": $scope.ticketSub, "assignedTo": $scope.assignedTo, "comments": $scope.comments, "createdBy": "Dummy User", "status": $rootScope.ticket.status};
				if($rootScope.authenticated){
					TicketService.updateTicket(ticket,function(response) {

						if (response) {
							$location.path('/home');
						}
						else {
							$scope.error = response.message;
							$scope.dataLoading = false;
						}
					});
				}
				else{
					$location.path('/login');
				}
			};

			$scope.goToCreateTicket = function() {
				$location.path('/createticket');
			}

			$scope.editTicket = function(ticket) {

				if (ticket.status == 'Open') {
					$rootScope.ticket = ticket;
					$location.path('/updateticket');
				}
			}

			$scope.toggleStatus = function(ticket) {

				if(ticket.status === 'Open')
					ticket.status = 'Closed';
				else
					ticket.status = 'Open';

				TicketService.updateTicket(ticket,function(response) {

					if (response) {
						$location.path('/home');
					}
					else {
						$scope.error = response.message;
						$scope.dataLoading = false;
					}
				});
			}

			$scope.ticketSelectionShow = function(status){
				$scope.tickets = $filter('filter')($rootScope.tickets,status);
			}

			$scope.logout = function(){

				TicketService.logout(function(response){

					if (response) {
						$rootScope.authenticated = false;
						$location.path('/login');
					}
					else {
						$scope.error = response.message;
						$scope.dataLoading = false;
					}
				});
			}
			$scope.init = function(){

				$scope.loadAllTickets();
			};

			$scope.updateFormInit = function(){

				if($rootScope.ticket){
					$scope.custName = $rootScope.ticket.custName;
					$scope.email = $rootScope.ticket.email;
					$scope.ticketSub = $rootScope.ticket.ticketSub;
					$scope.assignedTo = $rootScope.ticket.assignedTo;
					$scope.comments = $rootScope.ticket.comments;
				}
			};
		}]);


