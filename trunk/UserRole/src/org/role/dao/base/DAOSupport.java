package org.role.dao.base;

import java.io.Serializable;
import javax.annotation.Resource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.role.common.GenericsUtils;

public class DAOSupport<T> implements DAO<T>{
	
	protected Class<T> entityClass = GenericsUtils.getSuperClassGenricType(this.getClass());
	
	@Resource
	private SessionFactory sessionFactory;
	
	public Session getHibernateSession(){
		return sessionFactory.getCurrentSession();
	}

	public void delete(Serializable... entityids) {
		for (Object id : entityids) {
			Object columnType = this.getHibernateSession().get(this.entityClass, (Serializable) id);
			this.getHibernateSession().delete(columnType);
		}
	}

	public T get(Serializable entityId) {
		if (entityId == null)
			throw new RuntimeException(this.entityClass.getName() + ":�����ʵ��id����Ϊ��");
		Object object = this.getHibernateSession().get(entityClass, entityId);
		return (T)object;
	}

	public void save(Object entity) {
		this.getHibernateSession().persist(entity);
	}

	public void update(Object entity) {
		this.getHibernateSession().merge(entity);
	}
}
