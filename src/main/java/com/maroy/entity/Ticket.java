/**
 * 
 */
package com.maroy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author MaRoy
 *
 */
@Entity
@Table(name="T_TICKET")
public class Ticket {

	@Id
	@GeneratedValue
	@Column(name="ID")
	private Integer id;
	
	@Column(name="CUST_NAME")
	private String custName;
	
	@Column(name="CUST_EMAIL")
	private String email;
	
	@Column(name="TICKET_SUB")
	private String ticketSub;
	
	@Column(name="ASSIGNED_TO")
	private String assignedTo;
	
	@Column(name="COMMENTS")
	private String comments;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="STATUS")
	private String status;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the custInfo
	 */
	public String getCustName() {
		return custName;
	}

	/**
	 * @param custInfo the custInfo to set
	 */
	public void setCustName(String custName) {
		this.custName = custName;
	}

	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the assignedTo
	 */
	public String getAssignedTo() {
		return assignedTo;
	}

	/**
	 * @param assignedTo the assignedTo to set
	 */
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the ticketSub
	 */
	public String getTicketSub() {
		return ticketSub;
	}

	/**
	 * @param ticketSub the ticketSub to set
	 */
	public void setTicketSub(String ticketSub) {
		this.ticketSub = ticketSub;
	}
	
	
}
