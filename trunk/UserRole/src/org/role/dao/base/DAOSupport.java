package org.role.dao.base;

import java.io.Serializable;
import javax.annotation.Resource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.role.common.GenericsUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class DAOSupport<T> extends HibernateDaoSupport implements DAO<T>{
	
	protected Class<T> entityClass = GenericsUtils.getSuperClassGenricType(this.getClass());
	
	@Resource(name="sessionFactory")
	public void setSessFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	public Session getHibernateSession(){
		return super.getSessionFactory().getCurrentSession();
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
		System.out.println(this.entityClass.getName());
		return (T)this.getHibernateSession().get(entityClass, entityId);
	}

	public void save(Object entity) {
		this.getHibernateSession().save(entity);
	}

	public void update(Object entity) {
		this.getHibernateSession().merge(entity);
	}
}
