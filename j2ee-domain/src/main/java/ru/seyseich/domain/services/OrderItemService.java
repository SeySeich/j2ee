package ru.seyseich.domain.services;

import org.springframework.beans.factory.annotation.Autowired;

import ru.seyseich.domain.entities.OrderItem;
import ru.seyseich.domain.repositories.IRepository;
import ru.seyseich.domain.repositories.OrderItemRepository;

public class OrderItemService extends AbstractService< OrderItem > implements IOrderItemService
{
	@Autowired
	private OrderItemRepository repository;
	
	public Class< ? extends OrderItem > getEntityClass( )
	{
		return OrderItem.class;
	}

	@Override
	protected IRepository< OrderItem > getRepository( )
	{
		return repository;
	}

	@Override
	protected void copyProperties( OrderItem object, OrderItem dbObject )
	{
		dbObject.setOrder( object.getOrder( ) );
		dbObject.setProduct( object.getProduct( ) );
		dbObject.setQuantity( object.getQuantity( ) );
		dbObject.setWarehouse( object.getWarehouse( ) );
	}
}
