package org.role.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.role.dao.TgroupDAO;
import org.role.dao.base.DAOSupport;
import org.role.pojo.Tgroup;
import org.springframework.stereotype.Repository;

@Repository("tgroupDAO")
public class TgroupDAOImpl extends DAOSupport<Tgroup> implements TgroupDAO {
	public List<Tgroup> get(int count) {
		Session session = super.getHibernateSession();
		session.beginTransaction();
		String HQL = "FROM Tgroup";
		return session.createQuery(HQL).setFirstResult(0).setMaxResults(count).list();
	}
}
