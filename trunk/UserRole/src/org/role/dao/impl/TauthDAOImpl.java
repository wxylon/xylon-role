package org.role.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.role.dao.TRoleDAO;
import org.role.dao.TauthDAO;
import org.role.dao.base.DAOSupport;
import org.role.pojo.Tauth;
import org.springframework.stereotype.Repository;

@Repository("tauthDAO")
public class TauthDAOImpl extends DAOSupport implements TauthDAO {

	public List<Tauth> get(int count) {
		Session session = super.getHibernateSession();
		session.beginTransaction();
		String HQL = "FROM Tauth";
		return session.createQuery(HQL).setFirstResult(0).setMaxResults(count).list();
	}
	
}
