package org.role.service;

import java.util.List;

import org.role.dao.base.DAO;
import org.role.pojo.Tauth;

public interface ITauth extends DAO{
	public List<Tauth> get(int count);
}
