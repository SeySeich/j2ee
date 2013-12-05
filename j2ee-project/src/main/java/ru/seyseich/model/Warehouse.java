package ru.seyseich.model;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;

import ru.seyseich.jndi.objects.WarehouseConfig;
import ru.seyseich.utils.LogUtil;

public class Warehouse implements IWarehouse
{
	private static final Logger log = LoggerFactory
			.getLogger( Warehouse.class );
	
	public static final int DEFAULT_MAX_ITEM_AMOUNT = 100;
	
	private Set< Goods > _goods = new HashSet< Goods >( );
	private WarehouseConfig _warehouseConfig;
	private int _maxItemAmount = DEFAULT_MAX_ITEM_AMOUNT;
	
	private int overallItemAmount = 0;
	
	// @formatter:off
	@Required
	public void setGoods( Set< Goods > goods ) 
	{ 
		_goods = goods;
		if ( null != goods )
			for ( Goods good : _goods )
			{
				int qnt = good.getQuantity( );
				int newAmount = overallItemAmount + qnt;
				if ( newAmount <= _maxItemAmount )
					overallItemAmount = newAmount;
				else
				{
					String message = String.format( 
							"Не могу добавить товар на склад. Максимальное количество единиц %s превышено.", _maxItemAmount );
					log.info( "Ошибка: {}", message );
				}
			}
	}
	
	public Set< Goods > getGoods( ) { return _goods; }
	
	@Required
	public void setWarehouseConfig( WarehouseConfig config ) { _warehouseConfig = config; }
	public WarehouseConfig getWarehouseConfig( ) { return _warehouseConfig; }
	// @fomatter:on
	
	public void init( )
	{
		
	}
	
	public void changeAmount( Map< String, Integer > goods )
    {
		if ( null != goods )
		{
			for ( Goods good : _goods )
			{
				String name = good.getName( );
				Integer change = goods.get( name );
				if ( null != change )
				{
					int qnt = good.getQuantity( );
					int newQnt = qnt + change;
					good.setQuantity( newQnt );
					LogUtil.log( "Изменено количество товара %s на %s: %s -> %s", name, change, qnt, newQnt );
				}
			}
		}
    }
}
