package ru.seyseich.mvc.requests;

import ru.seyseich.model.pojos.OrderModel;

public class OrderRequest extends Request
{
	private OrderModel order;

	public OrderModel getOrder( )
	{
		return order;
	}

	public void setOrder( OrderModel order )
	{
		this.order = order;
	}
}
