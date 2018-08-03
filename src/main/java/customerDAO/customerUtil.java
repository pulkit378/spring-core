package customerDAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import bean.ReportBean;
import pojo.customer;

@Repository
public class customerUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties());

			return configuration.buildSessionFactory(ssrb.build());

		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}

	public boolean addCustomer(customer cust) {
		Session session = customerUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(cust);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}
	
	
	public boolean updateCustomer(customer cust){
			Session session = customerUtil.getSessionFactory().openSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				session.update(cust);
				tx.commit();
			} catch (HibernateException e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			} finally {
			session.close();
			}
			return false;
		   }
		
	public boolean deleteCustomer(Integer id){
	      Session session = customerUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         customer cust = (customer)session.get(customer.class, id); 
	         session.delete(cust); 
	         tx.commit();
	         return true;
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return false;
	   }
	
	
	

	public customer loadCustomer(Integer id) {
		Session session = customerUtil.getSessionFactory().openSession();
		Transaction tx = null;
		customer cust = new customer();
		try {
			tx = session.beginTransaction();
			cust = (customer)session.get(customer.class, id); 
			tx.commit();
			return cust;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return cust;
	}


	public List<customer> getCustomers(String zipCode) throws Exception {
		
		Session session = customerUtil.getSessionFactory().openSession();
        
        session.beginTransaction();
        
        Query query =  session.createQuery("FROM customer where ZIP_CODE= " + zipCode);
        query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<customer> customersLst = query.list();
        
        session.getTransaction().commit();
        session.close();
        
       	return customersLst;
	}
	
	
	
	
	
	
	
	
	
	
	
	public Map<String, Double> totalSales(int year) throws Exception {
		
		Session session = customerUtil.getSessionFactory().openSession();
        
        session.beginTransaction();
        

        Query query =  session.createQuery("Select MONTH(basic.order.payment_due_date), SUM(basic.product.PRICE*basic.order_product*quantity) FROM pojo.order, pojo.prduct, pojo.orer_product year(order.payment_due_date)=:payMentYear group by month(order.payment_due_date)");
		
        query.setParameter("paymentYear", year);
        List<List<Object>> listMonthlySales = query.setResultTransformer(Transformers.TO_LIST).list();
        Map<String,Double> mapMonthlySales = new HashMap<String, Double>();
        for(List<Object> x: listMonthlySales) {
        	mapMonthlySales.put (x.get(0) + "", (Double)x.get(1));
        }
        
        session.getTransaction().commit();
        session.close();
        return mapMonthlySales;
    
       	
	}
	
	
	public List<ReportBean> getReport(int month) throws Exception {
		
		Session session = customerUtil.getSessionFactory().openSession();
        
        session.beginTransaction();
        
        Query query =  session.createQuery("Select new bean.ReportBean(cu.first_name, cu_last_name, p.price* op.quantity as total) FROM pojo.customer as cu, pojo.product as p, pojo.order_product as op where p.product_id = op.product_id AND c.id = o.id AND op.order_id = o.order_id AND month(o.payment_due_date)=:paymentMonth ");
		
        List<ReportBean> reportBean = query.list();
    
    
        session.getTransaction().commit();
        session.close();
        return reportBean;
    
       	
	}
	



}
	
	
	
	
	
	
	
