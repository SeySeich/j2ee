package ru.seyseich.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ru.seyseich.domain.repositories.IRepository;
import ru.seyseich.domain.entities.Warehouse;

public class WarehouseService implements IService< Warehouse >
{
	@Autowired
	private WarehouseRepository repository;
	
	@Transactional
	public Warehouse create( Warehouse object )
	{
		return repository.save( object );
	}

	@Transactional( rollbackFor = Exception.class )
	public Warehouse delete( int id ) 
		throws Exception
	{
		Warehouse warehouse = repository.findOne( id );
		if ( null == warehouse )
			throw new Exception( String.format( "Склад с ID = %s не найден.", id ) );
		
		repository.delete( warehouse );
		
		return warehouse;
	}

	@Transactional
	public List<Warehouse> findAll( )
	{
		return repository.findAll( );
	}

	@Transactional( rollbackFor = Exception.class )
	public Warehouse update( Warehouse object ) throws Exception
	{
		Warehouse updated = null;
		
		if ( null != object )
		{
			updated = repository.findOne( object.getId( ) );
			if ( null == updated )
				throw new Exception( String.format( "Склад с ID = %s не найден.", object.getId( ) ) );
			
			updated.setCapacity( object.getCapacity( ) );
			updated.setName( object.getName( ) );
			repository.save( object );
		}
		
		return updated;
	}

	@Transactional
	public Warehouse findById( int id )
	{
		return repository.findOne( id );
	}
	
	public Class<? extends Warehouse> getEntityClass( )
	{
		return Warehouse.class;
	}
	
	private static interface WarehouseRepository extends IRepository< Warehouse >
	{
		// Empty
	}
}
