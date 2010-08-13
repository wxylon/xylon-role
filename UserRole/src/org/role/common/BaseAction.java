package org.role.common;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;   
import com.opensymphony.xwork2.ActionSupport;   
   
public class BaseAction extends ActionSupport {   
       
    private static final long serialVersionUID = -7509152655359967096L;
    
	protected Log log = LogFactory.getLog(this.getClass());
   
	protected Map session = new HashMap();
    protected Map request = new HashMap();   
    protected ServletContext servletContext;
	public String execute() throws Exception{
    	return super.execute();
	}

    public void setSession(Map session) {
        this.session=session;
    }
    
    public void setRequest(Map request) {
        this.request=request;
    }

	public void setServletContext(ServletContext arg0) {
		this.servletContext=arg0;
	}
       
    public Map getSession() {
		return session;
	}

	public Map getRequest() {
		return request;
	}

	public ServletContext getServletContext() {
		return servletContext;
	}

	// 保存一条错误    
    protected void saveActionError(String key) {   
        super.addActionError(super.getText(key));   
    }   
       
    // 保存一个消息    
    protected void saveActionMessage(String key) {   
        super.addActionMessage(super.getText(key));   
    }   
       
    // 取得查询的URL    
    protected String getRequestPath() {   
        return (String)ServletActionContext.getRequest().getServletPath();   
    }   
}   
