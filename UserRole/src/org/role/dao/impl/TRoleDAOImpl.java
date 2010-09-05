package org.role.dao.impl;

import java.util.List;

import org.role.dao.TRoleDAO;
import org.role.dao.base.DAOSupport;
import org.role.pojo.Trole;
import org.springframework.stereotype.Repository;

@Repository("tRoleDAO")
public class TRoleDAOImpl extends DAOSupport<Trole> implements TRoleDAO {

	public List<Trole> get() {
		String HQL = "FROM Trole";
		return super.getHibernateSession().createQuery(HQL).list();
	}
}
