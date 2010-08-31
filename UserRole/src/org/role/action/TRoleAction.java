package org.role.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.role.common.BaseAction;
import org.role.pojo.Trole;
import org.role.service.ITRole;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller("tRoleAction")
@Scope("prototype")
public class TRoleAction extends BaseAction {
	
	@Resource ITRole iTRole;
	private Trole trole;
	private List<Trole> troles;
	
	public String get() throws Exception {
		log.debug("TRoleAction--->get--->start");
		troles = iTRole.get();
		for(int i = 0; i < troles.size(); i++){
			troles.get(i).setTauths(null);
			troles.get(i).setTgroups(null);
			troles.get(i).setTusers(null);
		}
		return ActionSupport.SUCCESS;
	}
	
	
	public String save() throws Exception {
		try {
			log.debug("TRoleAction--->save--->start");
			if(null != trole){
				trole.setCreateTime(new Date());
				iTRole.save(trole);
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return "forward";
	}

	public Trole getTrole() {
		return trole;
	}

	public void setTrole(Trole trole) {
		this.trole = trole;
	}

	public List<Trole> getTroles() {
		return troles;
	}

	public void setTroles(List<Trole> troles) {
		this.troles = troles;
	}
}
