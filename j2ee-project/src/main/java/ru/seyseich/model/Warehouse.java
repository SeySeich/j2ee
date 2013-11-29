package ru.seyseich.model;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Required;

import ru.seyseich.utils.LogUtil;

public class Warehouse implements IWarehouse
{
	private Set< Goods > _goods = new HashSet< Goods >( );
	
	// @formatter:off
	@Required
	public void setGoods( Set< Goods > goods ) { _goods = goods; }
	public Set< Goods > getGoods( ) { return _goods; }
	// @fomatter:on
	
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
