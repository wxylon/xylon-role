package org.role.dao;

import java.util.List;

import org.role.dao.base.DAO;
import org.role.pojo.Trole;

public interface TRoleDAO extends DAO<Trole>{
	public List<Trole> get();
}
