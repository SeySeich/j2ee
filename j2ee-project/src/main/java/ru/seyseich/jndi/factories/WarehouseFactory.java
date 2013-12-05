package ru.seyseich.jndi.factories;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.RefAddr;
import javax.naming.Reference;
import javax.naming.spi.ObjectFactory;

import ru.seyseich.jndi.objects.WarehouseConfig;
import ru.seyseich.utils.GeneralUtil;

public class WarehouseFactory implements ObjectFactory
{
	public Object getObjectInstance( Object object, Name name, Context context,
			Hashtable< ?, ? > enviroment ) 
		throws Exception
	{
		if ( object instanceof Reference )
		{
			Reference reference = ( Reference ) object;
			
			if ( reference.getClass( ).equals( WarehouseConfig.class ) )
			{
				RefAddr maxItemAmountRef = reference.get( WarehouseConfig.MAX_ITEM_AMOUNT );
				RefAddr maxOneTypeItemAmountRef = reference.get( WarehouseConfig.MAX_ONE_TYPE_ITEM_AMOUNT );
				RefAddr nomenclatureUpdateFrequencyRef = reference.get( WarehouseConfig.NOMENCLATURE_UPDATE_FREQUENCY );
				RefAddr nameRef = reference.get( WarehouseConfig.NAME );
				
				if ( GeneralUtil.areNotNull( maxItemAmountRef, maxOneTypeItemAmountRef, nomenclatureUpdateFrequencyRef, name ) )
				{
					return new WarehouseConfig( 
							getIntegerContent( maxItemAmountRef ), 
							getIntegerContent( maxOneTypeItemAmountRef ),
							getIntegerContent( nomenclatureUpdateFrequencyRef ), 
							getContent( nameRef ) ); 
				}
			}
		}
			
		return null;
	}
	
	/**
	 * Null-safe получение содержимого jndi-свойства
	 */
	protected String getContent( RefAddr refAddr )
	{
		String content = null;
		if ( null != refAddr )
		{
			Object contentObj = refAddr.getContent( );
			if ( null != contentObj )
				content = contentObj.toString( );
		}
		
		return content;
	}
	
	/**
	 * 
	 * @param refAddr
	 * @return
	 */
	protected Integer getIntegerContent( RefAddr refAddr )
	{
		return Integer.valueOf( getContent( refAddr ) );
	}
}
