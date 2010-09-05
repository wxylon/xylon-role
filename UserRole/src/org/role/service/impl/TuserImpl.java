package org.role.service.impl;

import javax.annotation.Resource;
import org.role.dao.TuserDAO;
import org.role.dao.base.DAO;
import org.role.pojo.Tuser;
import org.role.service.ITuser;
import org.role.service.base.ServiceSupport;
import org.springframework.stereotype.Repository;

@Repository("iTuser")
public class TuserImpl extends ServiceSupport<Tuser> implements ITuser {
	
	@Resource TuserDAO tuserDAO ;
	
	public DAO getDAO() {
		return tuserDAO;
	}
}
