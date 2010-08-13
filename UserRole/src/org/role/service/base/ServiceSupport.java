package org.role.service.base;

import java.io.Serializable;

import org.role.common.GenericsUtils;
import org.role.dao.base.DAO;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("unchecked")
@Transactional
public abstract class ServiceSupport<T> implements Service<T>{
	
	protected Class<T> entityClass = GenericsUtils.getSuperClassGenricType(this.getClass());
	
	
	public abstract DAO<T> getDAO();

	public void delete(Serializable ... entityids) {
		getDAO().delete(entityids);
	}
	
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public T get(Serializable entityId) {
		return (T)getDAO().get(entityId);
	}

	public void save(Object entity) {
		getDAO().save(entity);
	}
		
	public void update(Object entity) {
		getDAO().update(entity);
	}
}
