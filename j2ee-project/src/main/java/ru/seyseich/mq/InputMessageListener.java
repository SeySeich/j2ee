package ru.seyseich.mq;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.seyseich.domain.entities.Product;
import ru.seyseich.mvc.responses.ProductsResponse;

public class InputMessageListener implements MessageListener
{
	private static final Logger log = LoggerFactory
			.getLogger( InputMessageListener.class );
	
	public void onMessage( Message message )
	{
		try
		{
			if ( ! ( message instanceof TextMessage ) )
				return ;
			
			TextMessage msg = ( TextMessage )message;
			String json = msg.getText( );
			
			ObjectMapper mapper = new ObjectMapper( );
			ProductsResponse obj = mapper.readValue( json, ProductsResponse.class );
			
			log.info( "Получили информацию о товарах:" );
			
			for ( Product product : obj.getProducts( ) )
			{
				log.info( "Товар: ID = {}, Название = {}, Описание = {}, Количество = {}", 
						new Object[ ] { product.getId( ), product.getName( ), product.getDescription( ), product.getQuantity( ) } );
			}
		}
		catch ( Exception exc )
		{
			// do nothing and don't bother
			log.error( "", exc );
		}
	}
}
