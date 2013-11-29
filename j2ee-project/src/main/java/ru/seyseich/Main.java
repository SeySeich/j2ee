package ru.seyseich;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.seyseich.model.Goods;
import ru.seyseich.model.IWarehouse;
import ru.seyseich.utils.LogUtil;

public class Main 
{
    public static void main( String[] args )
    {
    	LogUtil.log( "Приложение стартует..." );
    	
    	ApplicationContext appContext = new ClassPathXmlApplicationContext( "/application-context.xml" );
    	IWarehouse myWarehouse = ( IWarehouse ) appContext.getBean( "myWarehouse" );
    	
    	Map< String, Integer > changes = new HashMap< String, Integer >( );
    	changes.put( "Pens", 6 );
    	changes.put( "iPhones", -2 );
    	
    	myWarehouse.changeAmount( changes );
    	
    	for ( Goods good : myWarehouse.getGoods( ) )
    	{
    		LogUtil.log( "[%s] : %s : %s", good.getCategory( ).getName( ), good.getName( ), good.getQuantity( ) );
    	}
    	
    	LogUtil.log( "Приложение завершило свою работу." );
    }
}
