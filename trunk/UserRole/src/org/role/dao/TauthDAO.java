package org.role.dao;

import java.util.List;

import org.role.dao.base.DAO;
import org.role.pojo.Tauth;

public interface TauthDAO extends DAO<Tauth>{
	public List<Tauth> get(int count);
}
