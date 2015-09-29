# Ticketing Application #

---------------------------
    General Description
---------------------------

It is ticketing application created to view, monitor,edit and add tickets in the environment.
It is just a POC created for the RedMart home task.

---------------------------
    Technologies used
---------------------------

* Server side
	* Spring MVC for Rest based web services
	* Spring Security for authentication and authorization.
	* Hibernate for persistence
	* HSQLDB for in memory database.
	
* Client Side
	* Angular JS for client side
	* Bootstrap CSS

-----------------------------------
	How it works?
-----------------------------------

* Log in(If already registered. Otherwise register and then login)
* Home screen has list of tickets from the system. Since it is based on in memory database so after fresh deploy there won't be any data.
* User can add tickets by clicking on create ticket button.
* List of tickets are searchable.
* Also it can be filtered based on status.
* Click on any open ticket to edit it.
* Click on status to close open ticket.
* Once ticket is closed. It cannot be edited.
* Press on logout button to logout and redirect to login screen.
