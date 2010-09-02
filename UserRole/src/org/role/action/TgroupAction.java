package org.role.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.role.common.BaseAction;
import org.role.pojo.Tgroup;
import org.role.service.ITRole;
import org.role.service.ITauth;
import org.role.service.ITgroup;
import org.role.service.ITorganization;
import org.role.service.ITuser;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionSupport;

@Controller("tgroupAction")
@Scope("prototype")
public class TgroupAction extends BaseAction {
	
	@Resource ITgroup iTgroup;
	@Resource ITauth iTauth;
	@Resource ITorganization iTorganization;
	@Resource ITRole iTRole;
	@Resource ITuser iTuser;
	
	private List<Tgroup> tgroups;
	private Tgroup tgroup;
	
	public String get() throws Exception {
		int i = 0;
		while(i < 1000){
			log.debug("TgroupAction--->get--->start");
			tgroups = iTgroup.get(10);
			log.debug(i);
			iTauth.get(41);
			iTorganization.get(41);
			iTgroup.get(41);
			i++;
		}
		return ActionSupport.SUCCESS;
	}
	
	public String save() throws Exception{
		tgroup.setCreateTime(new Date());
		iTgroup.save(tgroup);
		return "forward";
	}

	public List<Tgroup> getTgroups() {
		return tgroups;
	}

	public void setTgroups(List<Tgroup> tgroups) {
		this.tgroups = tgroups;
	}

	public Tgroup getTgroup() {
		return tgroup;
	}

	public void setTgroup(Tgroup tgroup) {
		this.tgroup = tgroup;
	}
}
