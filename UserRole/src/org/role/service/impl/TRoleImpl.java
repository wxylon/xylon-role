package org.role.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.role.dao.TRoleDAO;
import org.role.dao.base.DAO;
import org.role.pojo.Trole;
import org.role.service.ITRole;
import org.role.service.base.ServiceSupport;
import org.springframework.stereotype.Repository;

@Repository("iTRole")
public class TRoleImpl extends ServiceSupport implements ITRole {
	
	@Resource TRoleDAO tRoleDAO;
	
	public DAO getDAO() {
		return tRoleDAO;
	}

	public List<Trole> get() {
		return tRoleDAO.get();
	}
}
