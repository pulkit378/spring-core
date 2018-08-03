package app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import customerDAO.customerUtil;
import orderDAO.OrderUtil;
import pojo.customer;
import pojo.order;


@Configuration
@Component
@ComponentScan({"customerDAO", "orderDAO"})
public class Application {
	public static void main(String[] args) throws Exception {
		ApplicationContext act = new AnnotationConfigApplicationContext(Application.class);
		customerUtil cu = new customerUtil();
		
		/* Implementing CustomerDAO */
		
		customer cust = new customer("Sahsib", "Singh"); 
		cu.addCustomer(cust);  // adding customer

		cust.setZipCode(95112);
		cu.updateCustomer(cust); // updating customer

		cu.deleteCustomer(33);

		customer temp = new customer(); // loading customer
		temp = cu.loadCustomer(35);
		System.out.println(temp);

		List<customer> customers = new ArrayList<customer>(); // displaying customers with a specific zipcode
		customers = cu.getCustomers("75063");
		for (customer c : customers) {
			System.out.println(c);
		}

		/* Implementing OrderDAO */

		OrderUtil ou = new OrderUtil();
		order ord = new order(cust);
		ou.addOrder(ord); // creating order
		ou.deleteOrder(4); // deleting order

	}
}
