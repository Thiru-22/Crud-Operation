package com.entity;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HiberanteManager {
	static Session session=null;
	static {
		session=new Configuration()
				.configure()
				.addAnnotatedClass(Registration.class)
				.buildSessionFactory()
				.openSession();
	}
	public void add(Registration reg) {
		Transaction ts=session.beginTransaction();
		session.persist(reg);
		ts.commit();
	}
	public void allData() {
		String query="FROM Registration";
		Query<Registration> qlist=session.createQuery(query,Registration.class);
		List<Registration> list=qlist.list();
		for(Registration r:list) {
			System.out.println(r);
		}
	}
	public void delete(int id) {
		Transaction ts=session.beginTransaction();
		Registration reg=session.get(Registration.class,id);
		session.delete(reg);
		ts.commit();
	}
	public void update(int id,String address) {
		Transaction ts=session.beginTransaction();
		Registration reg=session.get(Registration.class, id);
		reg.setAddress(address);
		session.update(reg);
		ts.commit();
	}
}
