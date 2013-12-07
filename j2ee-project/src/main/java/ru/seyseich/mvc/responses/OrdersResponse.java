package ru.seyseich.mvc.responses;

import java.util.List;

import ru.seyseich.domain.entities.Order;

public class OrdersResponse extends Response
{
	private List< Order > orders;

	public List< Order > getOrders( )
	{
		return orders;
	}

	public void setOrders( List< Order > orders )
	{
		this.orders = orders;
	}
}
