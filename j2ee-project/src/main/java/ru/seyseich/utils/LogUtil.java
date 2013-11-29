package ru.seyseich.utils;

public class LogUtil
{
	// @formatter:off
	private LogUtil( ) { }
	// @formatter:on
	
	public static void log( String format, Object... params )
	{
		System.out.println( String.format( format, params ) );
	}
}
