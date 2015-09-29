/**
 * 
 */
package com.maroy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maroy.entity.Ticket;

/**
 * @author MaRoy
 *
 */
@Service
public interface TicketService {

	public void createTicket(Ticket t);
	public void deleteTicket(Ticket t);
	public void updateTicket(Ticket t);
	public List<Ticket> getAllTickets();
}
