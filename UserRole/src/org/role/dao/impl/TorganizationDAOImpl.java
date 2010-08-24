package org.role.dao.impl;

import java.util.List;

import org.role.dao.TorganizationDAO;
import org.role.dao.base.DAOSupport;
import org.role.pojo.Torganization;
import org.springframework.stereotype.Repository;

@Repository("torganizationDAO")
public class TorganizationDAOImpl extends DAOSupport<Torganization> implements TorganizationDAO {

	public List<Torganization> get(int count) {
		String HQL = "FROM Torganization";
		return super.getHibernateSession().createQuery(HQL).setFirstResult(0).setMaxResults(count).list();
	}
}
