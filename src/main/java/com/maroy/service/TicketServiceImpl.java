/**
 * 
 */
package com.maroy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maroy.dao.TicketDao;
import com.maroy.entity.Ticket;

/**
 * @author MaRoy
 *
 */
@Service
public class TicketServiceImpl implements TicketService{

	@Autowired
	private TicketDao ticketDao;
	
	@Override
	@Transactional
	public void createTicket(Ticket t) {
		ticketDao.createTicket(t);
	}

	@Override
	@Transactional
	public void deleteTicket(Ticket t) {
		ticketDao.deleteTicket(t);
	}

	@Override
	@Transactional
	public void updateTicket(Ticket t) {
		ticketDao.updateTicket(t);
	}

	@Override
	@Transactional
	public List<Ticket> getAllTickets() {
		return ticketDao.getAllTickets();
	}
	
	/**
	 * @param ticketDao the ticketDao to set
	 */
	public void setTicketDao(TicketDao ticketDao) {
		this.ticketDao = ticketDao;
	}

}
