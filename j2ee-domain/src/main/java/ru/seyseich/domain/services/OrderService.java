package ru.seyseich.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ru.seyseich.domain.entities.Order;
import ru.seyseich.domain.repositories.IRepository;
import ru.seyseich.domain.repositories.OrderRepository;

public class OrderService extends AbstractService< Order > implements IOrderService
{
	@Autowired
	private OrderRepository repository;
	
	public Class< ? extends Order > getEntityClass( )
	{
		return Order.class;
	}

	@Override
	protected IRepository< Order > getRepository( )
	{
		return repository;
	}

	@Override
	protected void copyProperties( Order object, Order dbObject )
	{
		dbObject.setCustomer( object.getCustomer( ) );
	}

	public List< Order > getOrdersByCustomerIdAndId( Integer id, Integer customerId )
	{
		return repository.getOrdersByCustomerIdAndId( id, customerId );
	}
}
