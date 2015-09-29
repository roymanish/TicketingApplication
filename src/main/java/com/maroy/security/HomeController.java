package com.maroy.security;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maroy.entity.Ticket;
import com.maroy.entity.UserEntity;
import com.maroy.service.TicketService;
import com.maroy.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	String home(Locale locale, Model model) {
        return "index";
    }
	
	@RequestMapping(value="/create", method = RequestMethod.POST)
	public @ResponseBody String create(@RequestBody Ticket ticket) {
		
		try{
			ticketService.createTicket(ticket);
			return "success";
		}
		catch(Exception ex){
			return null;
		}
    }
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody String delete(@RequestBody @Validated Ticket ticket) {
		
		try{
			ticketService.deleteTicket(ticket);
			return "success";
		}
		catch(Exception ex){
			return null;
		}
    }
 
    @RequestMapping(value = "/getAll",method = RequestMethod.GET,produces="application/json")
    @ResponseBody List<Ticket> findAll() {
    	try{
    		List<Ticket> tickets = ticketService.getAllTickets();
			return tickets;
		}
		catch(Exception ex){
			return null;
		}
    }
 
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody String update(@RequestBody @Validated Ticket ticket) {
        
        try{
        	ticketService.updateTicket(ticket);
			return "success";
		}
		catch(Exception ex){
			return null;
		}
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody String register(@RequestBody @Validated UserEntity user) {
        
        try{
        	userService.addUser(user);
        	return "success";
		}
		catch(Exception ex){
			return null;
		}
    }
    
	/**
	 * @param ticketService the ticketService to set
	 */
	public void setTicketService(TicketService ticketService) {
		this.ticketService = ticketService;
	}
	
}
