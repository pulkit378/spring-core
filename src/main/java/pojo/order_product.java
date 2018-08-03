package pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "order_product")
public class order_product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_product_id")
	private int order_product_id;
	
	
	@Column(name = "quantity")
	private int quantity;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id", nullable = false)
	private order Order;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", nullable = false)
	private product Product;
	
	public order_product() {};
	
	public order_product(int order_product_id, int quantity) {
		super();
		this.order_product_id = order_product_id;
		this.quantity = quantity;
	}

	public int getOrder_product_id() {
		return order_product_id;
	}

	public void setOrder_product_id(int order_product_id) {
		this.order_product_id = order_product_id;
	}


	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public order getOrder() {
		return Order;
	}

	public void setOrder(order order) {
		Order = order;
	}


	public product getProduct() {
		return Product;
	}

	public void setProduct(product product) {
		Product = product;
	}
	
	
}
