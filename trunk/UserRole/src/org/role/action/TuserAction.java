package org.role.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.role.common.BaseAction;
import org.role.pojo.Torganization;
import org.role.pojo.Tuser;
import org.role.service.ITorganization;
import org.role.service.ITuser;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller("tuserAction")
@Scope("prototype")
public class TuserAction extends BaseAction {

	@Resource ITuser iTuser;
	@Resource ITorganization iTorganization;
	
	private Tuser tuser;
	private List<Tuser> tusers;
	
	public String save(){
		log.debug("TuserAction--->save--->start");
		if(null != tuser){
			try {
				tuser.setCreateTime(new Date());
				tuser.setLastLoginTime(new Date());
				tuser.setLoginCount(0);
				tuser.setLastLoginTime(new Date());
				tuser.setLoginTime(new Date());
				Torganization torganization = (Torganization)iTorganization.get(tuser.getTorganization().getToId());
				tuser.setTorganization(torganization);
				iTuser.save(tuser);
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}
		return ActionSupport.SUCCESS;
	}
	
	public String get(){
		log.debug("TuserAction--->get--->start");
		tusers = iTuser.get(10);
		for(int i = 0; i < tusers.size(); i++){
			tusers.get(i).setTauths(null);
			tusers.get(i).setTgroups(null);
			tusers.get(i).setTlogs(null);
			tusers.get(i).setTorganization(null);
			tusers.get(i).setTroles(null);
		}
		return "tuserrole";
	}

	public Tuser getTuser() {
		return tuser;
	}

	public void setTuser(Tuser tuser) {
		this.tuser = tuser;
	}

	public List<Tuser> getTusers() {
		return tusers;
	}

	public void setTusers(List<Tuser> tusers) {
		this.tusers = tusers;
	}
}
