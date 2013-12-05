package ru.seyseich.utils;

public class GeneralUtil
{
	// @formatter:off
	private GeneralUtil( ) { }
	// @formatter:on
	
	public static boolean areNotNull( Object... objects )
	{
		for ( Object object : objects )
			if ( null == object )
				return false;
		
		return true;
	}
}
