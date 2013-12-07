package ru.seyseich.mq;

import org.springframework.beans.factory.annotation.Required;

public class ProductsRequester
{
	private static final String REQUEST = "{ “type” : “products.request”, “warehouse” : { “ip” : “%s”, “port” : %s }, “limit” : %s }";
	private static final String PORT = "9000";
	private static final String HOST = "192.168.0.1";
	private static final String LIMIT = "10";
	
	private Producer _producer;
	
	// @formatter:off
	@Required
	public void setProducer( Producer producer ) { _producer = producer; }
	public Producer getProducer( ) { return _producer; }
	// @formatter:on
	
	public void requestProducts( )
	{
		String message = String.format( REQUEST, HOST, PORT, LIMIT );
		_producer.put( message );
	}
}
