package ru.seyseich.domain.entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseNamedEntity extends BaseEntity
{
	@Column( name = "name", nullable = false, length = 100 )
	protected String name;
	
	// @formatter:off
	public void setName( String name ) { this.name = name; }
	public String getName( ) { return name; }
	// @formatter:on
}
