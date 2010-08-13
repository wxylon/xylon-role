package org.role.common;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class InitApplication extends HttpServlet {
	
	public void init() throws ServletException {
		BeanHelp.init(getServletContext());	
	}
}
