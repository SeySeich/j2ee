package ru.seyseich.utils;

import java.util.Collection;
import java.util.List;

public class CollectionUtil
{
	public static boolean isNullOrEmpty( Collection< ? > collection )
	{
		return null == collection || collection.isEmpty( );
	}
	
	public static < T > T getFirst( List< T > collection )
	{
		return isNullOrEmpty( collection ) ? null : collection.get( 0 );
	}
}
