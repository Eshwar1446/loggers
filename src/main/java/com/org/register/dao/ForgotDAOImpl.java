package com.org.register.dao;

import java.util.Objects;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.register.entity.RegisterEntity;

@Component
public class ForgotDAOImpl implements ForgotDAO {

	@Autowired
	private SessionFactory factory;

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public ForgotDAOImpl() {
		System.out.println("Created \t" + this.getClass().getSimpleName());
	}

	public RegisterEntity fetchByEmail(String email, String pwd) {
		System.out.println("Invoked fetchByName() ....");
		Session session = null;
		Transaction tx = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			// session.getTransaction();
			System.out.println("fetching...");
			String hql = "SELECT re from RegisterEntity re where email='" + email + "'";
			System.out.println("Email" + hql);
			Query query = session.getNamedQuery("updatePasswordByEmail");

			query.setParameter("password", pwd);
			query.setParameter("email", email);

			Object result = query.executeUpdate();
			tx.commit();
			if (Objects.nonNull(result)) {
				System.out.println("Entity found" + result);

			} else {
				System.out.println("Entity not found");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("INFO:" + e.getMessage());
		} finally {
			session.close();
		}
		return null;
	}
}

/*
 * public RegisterEntity updatePasswordByEmail(String pwd, String mail) {
 * Session session = factory.openSession(); try {
 * System.out.println("invoke program...");
 * 
 * Query query = session.getNamedQuery("updatePasswordByEmail");
 * 
 * query.setParameter("password", pwd); query.setParameter("email", mail);
 * 
 * Object result = query.executeUpdate(); if (Objects.nonNull(result)) {
 * System.out.println("Entity found");
 * 
 * } else { System.out.println("Entity not found"); }
 * 
 * } catch (HibernateException he) { he.printStackTrace(); } finally { if
 * (Objects.nonNull(session)) session.close(); } return null; } }
 */