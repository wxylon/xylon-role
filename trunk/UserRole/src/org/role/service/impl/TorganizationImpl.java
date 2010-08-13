package org.role.service.impl;

import javax.annotation.Resource;
import org.role.dao.TorganizationDAO;
import org.role.dao.base.DAO;
import org.role.service.ITorganization;
import org.role.service.base.ServiceSupport;
import org.springframework.stereotype.Repository;

@Repository("iTorganization")
public class TorganizationImpl extends ServiceSupport implements ITorganization {
	
	@Resource TorganizationDAO torganizationDAO ;
	
	public DAO getDAO() {
		return torganizationDAO;
	}
}
