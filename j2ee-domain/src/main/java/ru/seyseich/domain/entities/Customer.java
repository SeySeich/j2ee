package ru.seyseich.domain.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name = "customer" )
public class Customer extends BaseNamedEntity
{
	@OneToMany( mappedBy = "customer", cascade = CascadeType.ALL )
	private List< Order > orders;
	
	// @formatter:off
	public void setOrders( List< Order > orders ) { this.orders = orders; }
	public List< Order > getOrders( ) { return orders; }
	// @formatter:on
}
