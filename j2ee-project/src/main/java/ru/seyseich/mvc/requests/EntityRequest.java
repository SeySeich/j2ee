package ru.seyseich.mvc.requests;

public class EntityRequest extends Request
{
	private Integer _id;
	
	// @formatter:off
	public void setId( Integer id  ) { _id = id; }
	public Integer getId( ) { return _id; }
	// @formatter:on
}
