package org.role.action;

import javax.annotation.Resource;

import org.role.common.BaseAction;
import org.role.service.ITRole;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller("tRoleAction")
@Scope("prototype")
public class TRoleAction extends BaseAction {
	
	@Resource ITRole iTRole;
	
	public String get() throws Exception {
		try {
			log.debug("TRoleAction--->get--->start"+iTRole.get().get(0).getTrName());
//			ServletActionContext.getRequest().setAttribute("tRoles", iTRole.get());
			request.put("tRoles", iTRole.get());
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return ActionSupport.SUCCESS;
	}
}
