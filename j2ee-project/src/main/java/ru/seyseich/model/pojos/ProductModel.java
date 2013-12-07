package ru.seyseich.model.pojos;

public class ProductModel
{
	private Integer categoryId;
	private Integer warehouseId;
	private String description;
	private float price;
	private float quantity;
	private float discount;
	private String name;
	
	public Integer getCategoryId( )
	{
		return categoryId;
	}
	public void setCategoryId( Integer categotyId )
	{
		this.categoryId = categotyId;
	}
	public Integer getWarehouseId( )
	{
		return warehouseId;
	}
	public void setWarehouseId( Integer warehouseId )
	{
		this.warehouseId = warehouseId;
	}
	public String getDescription( )
	{
		return description;
	}
	public void setDescription( String description )
	{
		this.description = description;
	}
	public float getPrice( )
	{
		return price;
	}
	public void setPrice( float price )
	{
		this.price = price;
	}
	public float getQuantity( )
	{
		return quantity;
	}
	public void setQuantity( float quantity )
	{
		this.quantity = quantity;
	}
	public float getDiscount( )
	{
		return discount;
	}
	public void setDiscount( float discount )
	{
		this.discount = discount;
	}
	public String getName( )
	{
		return name;
	}
	public void setName( String name )
	{
		this.name = name;
	}
}
