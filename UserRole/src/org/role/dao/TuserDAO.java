package org.role.dao;

import java.util.List;

import org.role.dao.base.DAO;
import org.role.pojo.Tuser;

public interface TuserDAO extends DAO<Tuser>{
	
	public List<Tuser> get(int count);
}
