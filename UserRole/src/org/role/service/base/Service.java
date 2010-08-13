package org.role.service.base;

import java.io.Serializable;
public interface Service<T> {

	/**
	 * 保存
	 * @param entity 
	 */
	public void save(Object entity);
	/**
	 * 更新
	 * @param entity 
	 */
	public void update(Object entity);
	/**
	 * 批量删除
	 * @param entityClass 
	 * @param entityids 
	 */
	public void delete(Serializable ... entityids);
	/**
	 * 得到实体
	 * @param <T>
	 * @param entityClass
	 * @param entityId
	 * @return
	 */
	public T get(Serializable entityId);
}
