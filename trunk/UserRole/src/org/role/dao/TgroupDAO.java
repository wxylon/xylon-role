package org.role.dao;

import java.util.List;

import org.role.dao.base.DAO;
import org.role.pojo.Tgroup;

public interface TgroupDAO extends DAO{
	public List<Tgroup> get(int count);
}
