package ru.seyseich.domain.services;

import org.springframework.beans.factory.annotation.Autowired;

import ru.seyseich.domain.entities.Category;
import ru.seyseich.domain.repositories.CategoryRepository;
import ru.seyseich.domain.repositories.IRepository;

public class CategoryService extends AbstractService< Category > implements ICategoryService
{
	@Autowired
	private CategoryRepository repository;
	
	public Class< ? extends Category > getEntityClass( )
	{
		return Category.class;
	}

	@Override
	protected IRepository< Category > getRepository( )
	{
		return repository;
	}

	@Override
	protected void copyProperties( Category object, Category dbObject )
	{
		dbObject.setName( object.getName( ) );
	}
}
