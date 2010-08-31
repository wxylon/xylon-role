package org.role.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.role.dao.TgroupDAO;
import org.role.dao.base.DAO;
import org.role.pojo.Tgroup;
import org.role.service.ITgroup;
import org.role.service.base.ServiceSupport;
import org.springframework.stereotype.Repository;

@Repository("iTgroup")
public class TgroupImpl extends ServiceSupport implements ITgroup {
	
	@Resource TgroupDAO tgroupDAO ;
	
	public DAO getDAO() {
		return tgroupDAO;
	}

	public List<Tgroup> get(int count) {
		return tgroupDAO.get(count);
	}
	
	
}
