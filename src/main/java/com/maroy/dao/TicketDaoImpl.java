/**
 * 
 */
package com.maroy.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.maroy.entity.Ticket;

/**
 * @author MaRoy
 *
 */
@Repository
public class TicketDaoImpl implements TicketDao{

	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public void createTicket(Ticket t) {
		this.sessionFactory.getCurrentSession().save(t);
	}

	@Override
	public void deleteTicket(Ticket t) {
		this.sessionFactory.getCurrentSession().delete(t);
	}

	@Override
	public void updateTicket(Ticket t) {
		this.sessionFactory.getCurrentSession().update(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ticket> getAllTickets() {
		
		List<Ticket> tickets = this.sessionFactory.getCurrentSession().createQuery("from Ticket").list();
		return tickets;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
