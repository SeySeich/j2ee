package ru.seyseich.model;

import org.springframework.beans.factory.annotation.Required;

public class Category
{
	private String _name;
	
	// @formatter:off
	@Required
	public void setName( String name ) { _name = name; }
	public String getName( ) { return _name; }
	// @formatter:on
}
