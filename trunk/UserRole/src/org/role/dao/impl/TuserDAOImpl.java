package org.role.dao.impl;

import java.util.List;

import org.role.dao.TuserDAO;
import org.role.dao.base.DAOSupport;
import org.role.pojo.Tuser;
import org.springframework.stereotype.Repository;

@Repository("tuserDAO")
public class TuserDAOImpl extends DAOSupport<Tuser> implements TuserDAO {
	public List<Tuser> get(int count){
		String HQL = "FROM Tuser";
		return super.getHibernateSession().createQuery(HQL).setFirstResult(0).setMaxResults(count).list();
	}
}
