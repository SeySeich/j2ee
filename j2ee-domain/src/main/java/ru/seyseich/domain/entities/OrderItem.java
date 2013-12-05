package ru.seyseich.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table( name = "order_item" )
public class OrderItem extends BaseEntity
{
	@OneToOne
	@JoinColumn( name = "id_order", nullable = false )
	private Order order;
	
	@ManyToOne
	@JoinColumn( name = "id_product", nullable = false )
	private Product product;
	
	@ManyToOne
	@JoinColumn( name = "id_warehouse", nullable = false )
	private Warehouse warehouse;
	
	@Column( name = "quantity", nullable = false )
	private float quantity;
	
	// @formatter:off
	public void setOrder( Order order ) { this.order = order; }
	public Order getOrder( ) { return order; }
	
	public void setProduct( Product product ) { this.product = product; }
	public Product getProduct( ) { return product; }
	
	public void setWarehouse( Warehouse warehouse ) { this.warehouse = warehouse; }
	public Warehouse getWarehouse( ) { return warehouse; }
	
	public void setQuantity( float quantity ) { this.quantity = quantity; }
	public float getQuantity( ) { return quantity; }
	// @formatter:on
}
