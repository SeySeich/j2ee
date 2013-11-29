package ru.seyseich.model;

import org.springframework.beans.factory.annotation.Required;

public class Goods
{
	private String _name;
	private double _price;
	private int _quantity;
	private Category _category;
	
	// @formatter:off
	@Required
	public void setName( String name ) { _name = name; }
	public String getName( ) { return _name; }
	
	@Required
	public void setQuantity( int quantity ) { _quantity = quantity; }
	public int getQuantity( ) { return _quantity; }
	
	@Required
	public void setPrice( double price ) { _price = price; }
	public double getPrice( ) { return _price; }
	
	@Required
	public void setCategory( Category category ) { _category = category; }
	public Category getCategory( ) { return _category; }
	// @formatter:on
}
