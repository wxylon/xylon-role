package org.role.action;

import javax.annotation.Resource;

import org.role.common.BaseAction;
import org.role.service.ITauth;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("tauthAction")
@Scope("prototype")
public class TauthAction extends BaseAction {
	@Resource ITauth iTauth;

	public String execute() throws Exception {
		return super.execute();
	}
	
	
}
