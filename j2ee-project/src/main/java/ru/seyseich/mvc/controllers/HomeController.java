package ru.seyseich.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ru.seyseich.domain.entities.Product;
import ru.seyseich.domain.entities.Warehouse;
import ru.seyseich.domain.services.IProductService;
import ru.seyseich.domain.services.IService;
import ru.seyseich.utils.ExceptionUtil;

@Controller
public class HomeController extends BaseController
{
	@Autowired
	@Qualifier( "warehouseService" )
	private IService< Warehouse > warehouseService;
	
	@Autowired
	@Qualifier( "productService" )
	private IProductService productService;
	
	@RequestMapping( value = "/", method = RequestMethod.GET )
	public ModelAndView index( )
	{
		ModelAndView index = new ModelAndView( "index" );
		index.addObject( "warehouses", warehouseService.findAll( ) );
		
		return index;
	}
	
	@RequestMapping( value = "/whinfo/{id}", method = RequestMethod.GET )
	public ModelAndView whinfo( @PathVariable( "id" ) Integer id )
		throws Exception
	{
		ModelAndView view = new ModelAndView( "whinfo" );
		
		Warehouse warehouse = warehouseService.findById( id );
		if ( null == warehouse )
			ExceptionUtil.throwException( "Склад с ID = %s не найден в БД.", id );
		
		view.addObject( "warehouse", warehouse );
		
		return view;
	}
	
	@RequestMapping( value = "/orders/warehouse/{warehouseId}/product/{productId}", method = RequestMethod.GET )
	public ModelAndView order( @PathVariable( "warehouseId" ) Integer warehouseId, 
			@PathVariable( "productId" ) Integer productId ) 
		throws Exception
	{
		ModelAndView view = new ModelAndView( "order" );
		
		Warehouse warehouse = warehouseService.findById( warehouseId );
		if ( null == warehouse )
			ExceptionUtil.throwException( "Склад с ID = %s не найден в БД.", warehouseId );
		
		view.addObject( "warehouse", warehouse );
		
		Product product = productService.findById( productId );
		if ( null == warehouse )
			ExceptionUtil.throwException( "Товар с ID = %s не найден в БД.", warehouseId );
		
		view.addObject( "warehouse", warehouse );
		view.addObject( "product", product );
		
		return view;
	}
}
