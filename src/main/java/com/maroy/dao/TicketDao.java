/**
 * 
 */
package com.maroy.dao;

import java.util.List;

import com.maroy.entity.Ticket;

/**
 * @author MaRoy
 *
 */
public interface TicketDao {

	public void createTicket(Ticket t);
	public void deleteTicket(Ticket t);
	public void updateTicket(Ticket t);
	public List<Ticket> getAllTickets();
}
