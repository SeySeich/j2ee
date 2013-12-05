package ru.seyseich.domain.services;

import java.util.List;

public interface IService< T >
{
	public T create( T object );
	public T delete( int id ) throws Exception;
	public List< T > findAll( );
	public T update( T object ) throws Exception;
	public T findById( int id );
	public Class< ? extends T > getEntityClass( );
}
