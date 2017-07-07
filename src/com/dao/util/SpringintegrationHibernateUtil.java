package com.dao.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class SpringintegrationHibernateUtil {
	
	static HibernateTemplate template;
	static SessionFactory localsessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		template = new HibernateTemplate(sessionFactory);
		localsessionFactory = sessionFactory;
	}

	public static HibernateTemplate getTempalte() {
		return template;
	}

	public static SessionFactory getSessionFactory() {
		return localsessionFactory;
	}
	
	public static Session getSession() {
		return localsessionFactory.openSession();
	}
}
