package orderDAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import customerDAO.customerUtil;
import orderDAO.OrderUtil;
import pojo.order;

public class OrderUtil {
	
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

	public boolean addOrder(order ord) {
		Session session = OrderUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(ord);
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
	
	
	public boolean updateOrder(order ord){
			Session session = OrderUtil.getSessionFactory().openSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				session.update(ord);
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
		
	public boolean deleteOrder(Integer orderid){
	      Session session = OrderUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         order ord = (order)session.get(order.class, orderid); 
	         session.delete(ord); 
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
	
	
	public order loadCustomer(Integer orderid) {
		Session session = customerUtil.getSessionFactory().openSession();
		Transaction tx = null;
		order ord = new order();
		try {
			tx = session.beginTransaction();
			ord = (order)session.get(order.class, orderid); 
			tx.commit();
			return ord;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return ord;
	}

}
