package ru.seyseich.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ru.seyseich.domain.entities.Warehouse;
import ru.seyseich.domain.services.IService;
import ru.seyseich.domain.services.WarehouseService;
import ru.seyseich.mvc.requests.EntityRequest;
import ru.seyseich.mvc.responses.ProductsResponse;
import ru.seyseich.mvc.responses.Response;

@Controller
@RequestMapping( "/warehouse" )
public class WarehouseController extends BaseController
{
	@Autowired
	@Qualifier( "warehouseService" )
	private IService< Warehouse > _warehouseService;
	
	@RequestMapping( value = "/hello", method = RequestMethod.GET )
	public @ResponseBody Response hello( )
	{
		Response response = new Response( );
		response.setStatus( "Hi!" );
		
		return response;
	}
	
	@RequestMapping( value = "/products", method = RequestMethod.GET )
	public @ResponseBody ProductsResponse getWarehouseProducts( @RequestBody EntityRequest request ) 
		throws Exception
	{
		ProductsResponse response = new ProductsResponse( );
		
		int id = request.getId( );
		Warehouse warehouse = _warehouseService.findById( id );
		if ( null == warehouse )
			throwException( "Склад с ID = %s не найден в БД!", id );
		
		response.setProducts( warehouse.getProducts( ) );
		
		return response;
	}
}
