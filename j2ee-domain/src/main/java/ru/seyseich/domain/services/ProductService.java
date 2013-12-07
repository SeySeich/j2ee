package ru.seyseich.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ru.seyseich.domain.entities.Product;
import ru.seyseich.domain.repositories.ProductRepository;

public class ProductService implements IProductService
{
	@Autowired
	private ProductRepository repository;
	
	@Transactional
	public Product create( Product object )
	{
		return repository.save( object );
	}

	@Transactional( rollbackFor = Exception.class )
	public Product delete( int id ) 
		throws Exception
	{
		Product product = repository.findOne( id );
		if ( null == product )
			throw new Exception( String.format( "Товар с ID = %s не найден.", id ) );
		
		repository.delete( product );
		
		return product;
	}

	@Transactional
	public List< Product > findAll( )
	{
		return repository.findAll( );
	}

	@Transactional( rollbackFor = Exception.class )
	public Product update( Product object ) throws Exception
	{
		Product product = null;
		if (null != object )
		{
			product = repository.findOne( object.getId( ) );
			if ( null == product )
				throw new Exception( String.format( "Товар с ID = %s не найден.", object.getId( ) ) );
			
			product.setCategory( object.getCategory( ) );
			product.setDescription( object.getDescription( ) );
			product.setDiscount( object.getDiscount( ) );
			product.setName( object.getName( ) );
			product.setPrice( object.getPrice( ) );
			product.setQuantity( object.getQuantity( ) );
			product.setWarehouse( object.getWarehouse( ) );
			
			repository.save( product );
		}
		
		return product;
	}

	@Transactional
	public Product findById( int id )
	{
		return repository.findOne( id );
	}

	public Class< ? extends Product > getEntityClass( )
	{
		return Product.class;
	}

}
