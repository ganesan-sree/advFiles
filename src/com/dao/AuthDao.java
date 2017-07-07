package com.dao;

import java.util.Collection;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import com.bean.User;
import com.dao.util.SpringintegrationHibernateUtil;

public class AuthDao {

	public User checkLogin(User user) {
		Session session = SpringintegrationHibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Criteria c = session.createCriteria(User.class);
		c.add(Restrictions.eq("email", user.getEmail()));
		c.add(Restrictions.eq("password", user.getPassword()));
		List<User> list = c.list();
		if (list.size() > 0){
			tx.commit();
			return list.get(0);
		}
		tx.commit();
		session.clear();
		session.flush();
		return null;
	}
	
	
	public User findByUsername(String  userName) {
		Session session = SpringintegrationHibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Criteria c = session.createCriteria(User.class);
		c.add(Restrictions.eq("username", userName));		
		List<User> list = c.list();
		if (list.size() > 0)	{
			tx.commit();
			return list.get(0);	
		}
		tx.commit();
		session.clear();
		session.flush();
		return null;
	}
	
	
	
	public void SaveUser(User user) {
		Session session = SpringintegrationHibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		tx.begin();
		session.saveOrUpdate(user);
		tx.commit();
		session.clear();
		session.flush();		
	}
	
	
	public Collection<User> listUser() {
		Session session = SpringintegrationHibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Criteria c = session.createCriteria(User.class);
		List<User> list = c.list();
		if (list.size() > 0) {
			tx.commit();
			return list;
		}
		tx.commit();
		session.clear();
		session.flush();
		return null;
	}
	
	public User findById(Integer  id) {
		Session session = SpringintegrationHibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Criteria c = session.createCriteria(User.class);
		c.add(Restrictions.eq("userId", id));		
		List<User> list = c.list();
		if (list.size() > 0)	{
			tx.commit();
			return list.get(0);	
		}
		tx.commit();
		session.clear();
		session.flush();
		return null;
	}
}
