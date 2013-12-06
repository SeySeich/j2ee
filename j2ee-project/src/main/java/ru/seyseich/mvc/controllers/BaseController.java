package ru.seyseich.mvc.controllers;

import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

public class BaseController
{
	private static final Logger log = LoggerFactory
			.getLogger( BaseController.class );
	
	private MappingJacksonJsonView jsonView = new MappingJacksonJsonView( );
	
	@ExceptionHandler( Exception.class )
	public ModelAndView handleException( Exception ex, HttpServletRequest req )
	{
		log.info( "Ошибка в работе контроллера({})! Message: {}", ex.getClass( ), ex.getMessage( ) );
		
		log.info( "Error in request: {}", req.getServletPath( ) );
		
		Hashtable< String, String > res = new Hashtable< String, String >( );
		res.put( "status", "fail" );
		res.put( "message", ex.getMessage( ) );
		
		return new ModelAndView( jsonView, res );
	}
	
	protected void throwException( String message, Object... args ) 
		throws Exception
	{
		throw new Exception( String.format( message, args ) );
	}
}
