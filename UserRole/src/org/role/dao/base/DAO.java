package org.role.dao.base;

import java.io.Serializable;
public interface DAO<T> {

	/**
	 * 保存实体
	 * @param entity 实体id
	 */
	public void save(Object entity);
	/**
	 * 更新实体
	 * @param entity 实体id
	 */
	public void update(Object entity);
	/**
	 * 删除实体
	 * @param entityClass 实体类
	 * @param entityids 实体id数组
	 */
	public void delete(Serializable ... entityids);
	/**
	 * 获取实体
	 * @param <T>
	 * @param entityClass 实体类
	 * @param entityId 实体id
	 * @return
	 */
	public T get(Serializable entityId);
}
