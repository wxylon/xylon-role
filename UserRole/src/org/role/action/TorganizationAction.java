package org.role.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.role.common.BaseAction;
import org.role.pojo.Torganization;
import org.role.service.ITorganization;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller("torganizationAction")
@Scope("prototype")
public class TorganizationAction extends BaseAction {

	private Torganization torganization;
	private List<Torganization> torgs;
	
	@Resource ITorganization iTorganization;
	
	public String save() throws Exception {
		log.debug("TorganizationAction--->save--->start");
		try {
			torganization.setCreateTime(new Date());
			iTorganization.save(torganization);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return ActionSupport.SUCCESS;
	}
	
	public String get(){
		log.debug("TorganizationAction--->get--->start");
		torgs = iTorganization.get(10);
		//将不需要的对象置空，否则出现懒加载异常
		for(Torganization torganization : torgs){
			torganization.setTusers(null);
		}
		return ActionSupport.SUCCESS;
	}

	public Torganization getTorganization() {
		return torganization;
	}

	public void setTorganization(Torganization torganization) {
		this.torganization = torganization;
	}

	public List<Torganization> getTorgs() {
		return torgs;
	}

	public void setTorgs(List<Torganization> torgs) {
		this.torgs = torgs;
	}
}
