package ru.seyseich.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ru.seyseich.mvc.responses.Response;

@Controller
@RequestMapping( "/warehouse" )
public class WarehouseController
{
	@RequestMapping( value = "/hello", method = RequestMethod.GET )
	public @ResponseBody Response hello( )
	{
		Response response = new Response( );
		response.setStatus( "Hi!" );
		
		return response;
	}
}
