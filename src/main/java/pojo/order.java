package pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "ORDERS")
public class order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int order_id;
	
	@Column(name = "invoice_date")
	private Date invoice_Creation_date;
	
	
	@Column(name = "delivery_date")
	private Date delivery_due_date;
	
	
	@Column(name = "payment_date")
	private Date payment_due_date;
	
	@ManyToOne
	@JoinColumn(name = "id", nullable = false)
	private customer Customer;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Order")
	private Set<order_product> ops = new HashSet<order_product>();
	
	public order() {}
	
	public int getOrder_id() {
		return order_id;
	}

	public order(int order_id) {
		super();
		this.order_id = order_id;
	}
	

	public order(customer customer) {
		super();
		Customer = customer;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public Date getInvoice_Creation_date() {
		return invoice_Creation_date;
	}

	public void setInvoice_Creation_date(Date invoice_Creation_date) {
		this.invoice_Creation_date = invoice_Creation_date;
	}

	public Date getDelivery_due_date() {
		return delivery_due_date;
	}

	public void setDelivery_due_date(Date delivery_due_date) {
		this.delivery_due_date = delivery_due_date;
	}

	public Date getPayment_due_date() {
		return payment_due_date;
	}

	public void setPayment_due_date(Date payment_due_date) {
		this.payment_due_date = payment_due_date;
	}


	public customer getCustomer() {
		return Customer;
	}

	public void setCustomer(customer customer) {
		Customer = customer;
	}

	
	
	public Set<order_product> getOps() {
		return ops;
	}

	public void setOps(Set<order_product> ops) {
		this.ops = ops;
	}

		

}
