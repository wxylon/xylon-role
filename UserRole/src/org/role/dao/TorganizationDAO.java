package org.role.dao;

import java.util.List;

import org.role.dao.base.DAO;
import org.role.pojo.Torganization;

public interface TorganizationDAO extends DAO<Torganization>{
	public List<Torganization> get(int count);
}
