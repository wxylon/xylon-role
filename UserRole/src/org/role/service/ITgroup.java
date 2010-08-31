package org.role.service;

import java.util.List;

import org.role.dao.base.DAO;
import org.role.pojo.Tgroup;

public interface ITgroup extends DAO{
	public List<Tgroup> get(int count);
}
