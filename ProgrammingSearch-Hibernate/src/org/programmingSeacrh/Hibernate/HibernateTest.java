package org.programmingSeacrh.Hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.programmingSeacrh.Hibernate.dto.Address;
import org.programmingSeacrh.Hibernate.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDetails user=new UserDetails();
		//user.setUserId(1); as we have added @GeneratedValue
		user.setUserName("Anup");
		user.setAddress("Anup address");
		user.setJoinedDate(new Date());
		user.setDescription("description");
		
		
		/*UserDetails user2=new UserDetails();
		user2.setUserName("Prerana");
		user2.setAddress("Prerana address");
		user2.setJoinedDate(new Date());
		user2.setDescription("description");
		*/
		Address addr=new Address();
		addr.setCity("Navi Mumbai");
		addr.setStreet("Sector 8");
		
		Address addranup=new Address();
		addranup.setCity("Minnesota");
		addranup.setStreet("Mcknight");
 
		
		user.setUseraddress(addranup);
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
		applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		Session session=factory.openSession();
		//Start the transacction
		session.beginTransaction();
		//save the user
		session.save(user);
		//session.save(user2);
		//get the current transaction to commit
		session.getTransaction().commit();
		session.close();
		
		
		user =null;
		session= factory.openSession();
		session.beginTransaction();
		user=(UserDetails)session.get(UserDetails.class, 1);
		System.out.println(" User name "+user.getUserName());
		session.close();
		
		factory.close();
	}
		

}
