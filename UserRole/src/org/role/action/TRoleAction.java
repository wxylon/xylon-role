package org.role.action;

import java.util.Date;

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
	
	public String get() throws Exception {
		try {
			log.debug("TRoleAction--->get--->start");
//			ServletActionContext.getRequest().setAttribute("tRoles", iTRole.get());
			request.put("tRoles", iTRole.get());
		} catch (RuntimeException e) {
			e.printStackTrace();
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
		return ActionSupport.SUCCESS;
	}

	public Trole getTrole() {
		return trole;
	}

	public void setTrole(Trole trole) {
		this.trole = trole;
	}
}
