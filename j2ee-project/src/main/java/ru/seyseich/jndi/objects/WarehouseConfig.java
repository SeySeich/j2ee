package ru.seyseich.jndi.objects;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.naming.Referenceable;
import javax.naming.StringRefAddr;

import ru.seyseich.jndi.factories.WarehouseFactory;

public class WarehouseConfig implements Referenceable
{
	public static final String MAX_ITEM_AMOUNT = "maxItemAmount";
	public static final String MAX_ONE_TYPE_ITEM_AMOUNT = "maxOneTypeItemAmount";
	public static final String NOMENCLATURE_UPDATE_FREQUENCY = "nomenclatureUpdateFrequency";
	public static final String NAME = "name";
	
	private int _maxItemAmount;
	private int _maxOneTypeItemAmount;
	private int _nomenclatureUpdateFrequency;
	private String _name;
	
	// @formatter:off
	public int getMaxItemAmount( ) { return _maxItemAmount; }
	public int getMaxOneTypeItemAmount( ) { return _maxOneTypeItemAmount; }
	public int getNomenclatureUpdateFrequency( ) { return _nomenclatureUpdateFrequency; }
	public String getName( ) { return _name; }
	// @formatter:on
	
	public WarehouseConfig( int maxItemAmount, int maxOneTypeItemAmount, int nomenclatureUpdateFrequency, String name )
	{
		_maxItemAmount = maxItemAmount;
		_maxOneTypeItemAmount = maxOneTypeItemAmount;
		_nomenclatureUpdateFrequency = nomenclatureUpdateFrequency;
		_name = name;
	}
	
	public Reference getReference( ) throws NamingException
	{
		Reference reference = new Reference( 
				getClass( ).getName( ), new StringRefAddr( MAX_ITEM_AMOUNT, Integer.toString( _maxItemAmount ) ), 
				WarehouseFactory.class.getName( ), null );
		
		reference.add( new StringRefAddr( MAX_ONE_TYPE_ITEM_AMOUNT, Integer.toString( _maxOneTypeItemAmount ) )  );
		reference.add( new StringRefAddr( NOMENCLATURE_UPDATE_FREQUENCY, Integer.toString( _nomenclatureUpdateFrequency ) ) );
		reference.add( new StringRefAddr( NAME, _name ) );
		
		return reference;
	}
}
