package ru.seyseich.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ru.seyseich.domain.entities.Category;
import ru.seyseich.domain.entities.Customer;
import ru.seyseich.domain.entities.Order;
import ru.seyseich.domain.entities.Product;
import ru.seyseich.domain.entities.Warehouse;
import ru.seyseich.domain.services.ICategoryService;
import ru.seyseich.domain.services.ICustomerService;
import ru.seyseich.domain.services.IOrderService;
import ru.seyseich.domain.services.IProductService;
import ru.seyseich.domain.services.IService;
import ru.seyseich.model.pojos.OrderModel;
import ru.seyseich.model.pojos.ProductModel;
import ru.seyseich.mvc.requests.OrderRequest;
import ru.seyseich.mvc.requests.ProductRequest;
import ru.seyseich.mvc.responses.OrdersResponse;
import ru.seyseich.mvc.responses.ProductsResponse;
import ru.seyseich.mvc.responses.Response;
import ru.seyseich.utils.CollectionUtil;
import ru.seyseich.utils.ExceptionUtil;

@Controller
@RequestMapping( "/warehouse" )
public class WarehouseController extends BaseController
{
	@Autowired
	@Qualifier( "warehouseService" )
	private IService< Warehouse > warehouseService;
	
	@Autowired
	@Qualifier( "productService" )
	private IProductService productService;
	
	@Autowired
	@Qualifier( "categoryService" )
	private ICategoryService categoryService;
	
	@Autowired
	@Qualifier( "orderService" )
	private IOrderService orderService;
	
	@Autowired
	@Qualifier( "customerService" )
	private ICustomerService customerService;
	
	@RequestMapping( value = "/hello", method = RequestMethod.GET )
	public @ResponseBody Response hello( )
	{
		Response response = new Response( );
		response.setStatus( "Hi!" );
		
		return response;
	}
	
	@RequestMapping( value = "/products/{id}", method = RequestMethod.GET )
	public @ResponseBody ProductsResponse getWarehouseProducts( @PathVariable( "id" ) Integer id ) 
		throws Exception
	{
		ProductsResponse response = new ProductsResponse( );
		
		Warehouse warehouse = warehouseService.findById( id );
		if ( null == warehouse )
			throwException( "Склад с ID = %s не найден в БД!", id );
		
		response.setProducts( warehouse.getProducts( ) );
		
		return response;
	}
	
	@RequestMapping( value = "/products", method = RequestMethod.POST )
	public @ResponseBody Response postWarehouseProduct( @RequestBody ProductRequest request )
		throws Exception
	{
		ProductModel pojoProduct = request.getProduct( );
		
		Product product = new Product( );
		
		int categoryId = pojoProduct.getCategoryId( );
		Category category = categoryService.findById( categoryId );
		if ( null == category )
			ExceptionUtil.throwException( "Категории с ID = %s нет в БД.", categoryId );
		
		product.setCategory( category );
		
		int warehouseId = pojoProduct.getWarehouseId( );
		Warehouse warehouse = warehouseService.findById( warehouseId );
		if ( null == warehouse )
			ExceptionUtil.throwException( "Склад с ID = %s не найден в БД.", warehouseId );
		
		product.setWarehouse( warehouse );
		product.setDescription( pojoProduct.getDescription( ) );
		product.setDiscount( pojoProduct.getDiscount( ) );
		product.setName( pojoProduct.getName( ) );
		product.setPrice( pojoProduct.getPrice( ) );
		product.setQuantity( pojoProduct.getQuantity( ) );
		
		productService.create( product );
		
		return getOkResponse( );
	}
	
	@RequestMapping( value = "/products/{id}", method = RequestMethod.DELETE )
	public @ResponseBody Response deleteWarehouseProduct( @PathVariable( "id" ) Integer id )
		throws Exception
	{
		productService.delete( id );
		
		return getOkResponse( );
	}
	
	@RequestMapping( value = "/products/{id}", method = RequestMethod.PUT )
	public @ResponseBody Response putWarehouseProduct( @PathVariable( "id" ) Integer id, @RequestBody ProductRequest request ) 
		throws Exception
	{
		ProductModel pojoProduct = request.getProduct( );
		
		Product product = productService.findById( id );
		if ( null == product )
			ExceptionUtil.throwException( "Продукта с ID = %s нет в БД.", id );
		
		int categoryId = pojoProduct.getCategoryId( );
		Category category = categoryService.findById( categoryId );
		if ( null == category )
			ExceptionUtil.throwException( "Категории с ID = %s нет в БД.", categoryId );
		
		product.setCategory( category );
		
		int warehouseId = pojoProduct.getWarehouseId( );
		Warehouse warehouse = warehouseService.findById( warehouseId );
		if ( null == warehouse )
			ExceptionUtil.throwException( "Склад с ID = %s не найден в БД.", warehouseId );
		
		product.setWarehouse( warehouse );
		product.setDescription( pojoProduct.getDescription( ) );
		product.setDiscount( pojoProduct.getDiscount( ) );
		product.setName( pojoProduct.getName( ) );
		product.setPrice( pojoProduct.getPrice( ) );
		product.setQuantity( pojoProduct.getQuantity( ) );
		
		productService.update( product );
		
		return getOkResponse( );
	}
	
	@RequestMapping( value = "/orders", method = RequestMethod.POST )
	public @ResponseBody Response postWarehouseOrders( @RequestBody OrderRequest request )
		throws Exception
	{
		OrderModel pojoOrder = request.getOrder( );
		
		Order order = new Order( );
		
		int customerId = pojoOrder.getCustomerId( );
		Customer customer = customerService.findById( customerId );
		if ( null == customer )
			ExceptionUtil.throwException( "Покупателя с ID = %s нет в БД.", customerId );
		
		order.setCustomer( customer );
		
		orderService.create( order );
		
		return getOkResponse( );
	}
	
	@RequestMapping( value = "/orders/{id}", method = RequestMethod.PUT )
	public @ResponseBody Response putWarehouseOrders( @PathVariable( "id" ) Integer id, @RequestBody OrderRequest request ) 
		throws Exception
	{
		OrderModel pojoOrder = request.getOrder( );
		
		Order order = orderService.findById( id );
		if ( null == order )
			ExceptionUtil.throwException( "Заказ с ID = %s не найден в БД", id );
		
		int customerId = pojoOrder.getCustomerId( );
		Customer customer = customerService.findById( customerId );
		if ( null == customer )
			ExceptionUtil.throwException( "Покупателя с ID = %s нет в БД.", customerId );
		
		order.setCustomer( customer );
		
		orderService.update( order );
		
		return getOkResponse( );
	}
	
	@RequestMapping( value = "/orders/{id}", method = RequestMethod.DELETE )
	public @ResponseBody Response deleteWarehouseOrders( @PathVariable( "id" ) Integer id ) 
		throws Exception
	{
		orderService.delete( id );
		
		return getOkResponse( );
	}
	
	@RequestMapping( value = "/customers/{id}/orders", method = RequestMethod.GET )
	public @ResponseBody OrdersResponse getWarehouseCustomersOrders( @PathVariable( "id" ) Integer id ) 
		throws Exception
	{
		Customer customer = customerService.findById( id );
		if ( null == customer )
			ExceptionUtil.throwException( "Покупателя с ID = %s нет в БД.", id );
		
		OrdersResponse response = new OrdersResponse( );
		response.setOrders( customer.getOrders( ) );
		
		return response;
	}
	
	@RequestMapping( value = "/customers/{id}/orders/{orderId}", method = RequestMethod.DELETE )
	public @ResponseBody Response deleteWarehouseCustomersOrders( @PathVariable( "id" ) Integer customerId, 
			@PathVariable( "orderId" ) Integer orderId ) 
		throws Exception
	{
		Order order = CollectionUtil.getFirst( orderService.getOrdersByCustomerIdAndId( orderId, customerId ) );
		
		if ( null == order )
			ExceptionUtil.throwException( "У покупателя с ID = %s нет заказа с ID = %s.", customerId, orderId );
		
		orderService.delete( order.getId( ) );
		
		return getOkResponse( );
	}
}
