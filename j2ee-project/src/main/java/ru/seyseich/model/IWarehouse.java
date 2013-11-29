package ru.seyseich.model;

import java.util.Map;
import java.util.Set;

public interface IWarehouse
{
	// @formatter:off
	void setGoods( Set< Goods > goods );
	Set< Goods > getGoods( );
	
	void changeAmount( Map< String, Integer > goods );
	// @formatter:on
}
