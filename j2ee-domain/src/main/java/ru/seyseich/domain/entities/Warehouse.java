package ru.seyseich.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name = "warehouse" )
public class Warehouse extends BaseNamedEntity
{
	@Column( name = "capacity", nullable = false )
	private Integer capacity;
	
	// @formatter:off
	public void setCapacity( Integer capacity ) { this.capacity = capacity; }
	public Integer getCapacity( ) { return capacity; }
	// @formatter:on
}
