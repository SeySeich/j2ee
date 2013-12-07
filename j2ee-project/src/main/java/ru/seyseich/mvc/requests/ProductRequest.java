package ru.seyseich.mvc.requests;

import ru.seyseich.model.pojos.ProductModel;

public class ProductRequest extends Request
{
	private ProductModel product;

	public ProductModel getProduct( )
	{
		return product;
	}

	public void setProduct( ProductModel product )
	{
		this.product = product;
	}
}
