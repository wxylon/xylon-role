package org.role.service.impl;

import javax.annotation.Resource;
import org.role.dao.TlogDAO;
import org.role.dao.base.DAO;
import org.role.pojo.Tlog;
import org.role.service.ITlog;
import org.role.service.base.ServiceSupport;
import org.springframework.stereotype.Repository;

@Repository("iTlog")
public class TlogImpl extends ServiceSupport<Tlog> implements ITlog {
	
	@Resource TlogDAO tlogDAO ;
	
	public DAO getDAO() {
		return tlogDAO;
	}
}
