package org.role.action;

import java.util.List;

import javax.annotation.Resource;

import org.role.common.BaseAction;
import org.role.pojo.Tauth;
import org.role.service.ITauth;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller("tauthAction")
@Scope("prototype")
public class TauthAction extends BaseAction {
	@Resource ITauth iTauth;

	private List<Tauth> tauths;
	private Tauth tauth;
	
	public String execute() throws Exception {
		tauths = iTauth.get(10);
		return ActionSupport.SUCCESS;
	}
	
	public String save() throws Exception{
		iTauth.save(tauth);
		return ActionSupport.SUCCESS;
	}
	
	
	public List<Tauth> getTauths() {
		return tauths;
	}
	public void setTauths(List<Tauth> tauths) {
		this.tauths = tauths;
	}
	public Tauth getTauth() {
		return tauth;
	}
	public void setTauth(Tauth tauth) {
		this.tauth = tauth;
	}
}
