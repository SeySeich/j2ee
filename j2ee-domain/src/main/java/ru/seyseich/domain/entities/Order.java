package ru.seyseich.domain.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "order" )
public class Order extends BaseEntity
{
	@ManyToOne
	@JoinColumn( name = "id_customer", nullable = false )
	private Customer customer;
	
	// @formatter:off
	public void setCustomer( Customer customer ) { this.customer = customer; }
	public Customer getCustomer( ) { return customer; }
	// @formatter:on
}
