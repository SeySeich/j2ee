package ru.seyseich.domain.services;

import org.springframework.beans.factory.annotation.Autowired;

import ru.seyseich.domain.entities.Customer;
import ru.seyseich.domain.repositories.CustomerRepository;
import ru.seyseich.domain.repositories.IRepository;

public class CustomerService extends AbstractService< Customer > implements ICustomerService
{
	@Autowired
	private CustomerRepository repository;
	
	public Class< ? extends Customer > getEntityClass( )
	{
		return Customer.class;
	}

	@Override
	protected IRepository< Customer > getRepository( )
	{
		return repository;
	}

	@Override
	protected void copyProperties( Customer object, Customer dbObject )
	{
		dbObject.setName( object.getName( ) );
	}
}
