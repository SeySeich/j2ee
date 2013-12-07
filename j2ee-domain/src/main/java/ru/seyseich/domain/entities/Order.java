package ru.seyseich.domain.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table( name = "orders" )
public class Order extends BaseEntity
{
	@ManyToOne
	@JoinColumn( name = "id_customer", nullable = false )
	private Customer customer;
	
	// @formatter:off
	public void setCustomer( Customer customer ) { this.customer = customer; }
	@JsonIgnore public Customer getCustomer( ) { return customer; }
	// @formatter:on
}
