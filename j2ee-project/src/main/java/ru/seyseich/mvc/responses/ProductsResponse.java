package ru.seyseich.mvc.responses;

import java.util.List;

import ru.seyseich.domain.entities.Product;

public class ProductsResponse extends Response
{
	private List< Product > _products;
	
	// @formatter:off
	public void setProducts( List< Product > products ) { _products = products; }
	public List< Product > getProducts( ) { return _products; }
	// @formatter:on
}
