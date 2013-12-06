package ru.seyseich.domain.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name = "warehouse" )
public class Warehouse extends BaseNamedEntity
{
	@Column( name = "capacity", nullable = false )
	private Integer capacity;
	
	@OneToMany( mappedBy = "warehouse", cascade = CascadeType.ALL )
	private List< Product > products;
	
	// @formatter:off
	public void setCapacity( Integer capacity ) { this.capacity = capacity; }
	public Integer getCapacity( ) { return capacity; }
	
	public void setProducts( List< Product > products ) { this.products = products; }
	public List< Product > getProducts( ) { return products; }
	// @formatter:on
}
