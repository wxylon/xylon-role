package org.role.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.role.dao.TauthDAO;
import org.role.dao.base.DAO;
import org.role.pojo.Tauth;
import org.role.service.ITauth;
import org.role.service.base.ServiceSupport;
import org.springframework.stereotype.Repository;

@Repository("iTauth")
public class TauthImpl extends ServiceSupport<Tauth> implements ITauth {
	
	@Resource TauthDAO tauthDAO ;
	
	public DAO getDAO() {
		return tauthDAO;
	}

	public List<Tauth> get(int count) {
		return tauthDAO.get(count);
	}
}
