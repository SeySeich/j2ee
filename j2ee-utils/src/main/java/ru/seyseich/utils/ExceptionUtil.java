package ru.seyseich.utils;

public class ExceptionUtil
{
	public static Exception createException( String messageFormat, Object... args )
	{
		return new Exception( String.format( messageFormat, args ) );
	}
	
	public static void throwException( String messageFormat, Object... args )
		throws Exception
	{
		throw createException( messageFormat, args );
	}
}
