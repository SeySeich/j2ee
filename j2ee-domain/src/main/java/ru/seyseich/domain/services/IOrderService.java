package ru.seyseich.domain.services;

import java.util.List;

import ru.seyseich.domain.entities.Order;

public interface IOrderService extends IService< Order >
{
	public List< Order > getOrdersByCustomerIdAndId( Integer id, Integer customerId );
}
