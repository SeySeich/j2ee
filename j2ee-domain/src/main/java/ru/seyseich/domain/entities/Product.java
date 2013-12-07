package ru.seyseich.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table( name = "product" )
public class Product extends BaseNamedEntity
{
	@ManyToOne
	@JoinColumn( name = "id_category", nullable = false )
	private Category category;
	
	@ManyToOne
	@JoinColumn( name = "id_warehouse", nullable = false )
	private Warehouse warehouse;
	
	@Column( name = "description", nullable = true )
	private String description;
	
	@Column( name = "price", nullable = false )
	private float price;
	
	@Column( name = "quantity", nullable = false )
	private float quantity;
	
	@Column( name = "discount", nullable = true )
	private float discount;
	
	// @formatter:off
	public void setCategory( Category category ) { this.category = category; }
	public Category getCategory( ) { return category; }
	
	public void setWarehouse( Warehouse warehouse ) { this.warehouse = warehouse; }
	@JsonIgnore public Warehouse getWarehouse( ) { return warehouse; }
	
	public void setDescription( String description ) { this.description = description; }
	public String getDescription( ) { return description; }
	
	public void setPrice( float price ) { this.price = price; }
	public float getPrice( ) { return price; }
	
	public void setQuantity( float quantity ) { this.quantity = quantity; }
	public float getQuantity( ) { return quantity; }
	
	public void setDiscount( float discount ) { this.discount = discount; }
	public float getDiscount( ) { return discount; }
	// @formatter:on
}
