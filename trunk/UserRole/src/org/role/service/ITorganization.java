package org.role.service;

import java.util.List;
import org.role.pojo.Torganization;
import org.role.service.base.Service;

public interface ITorganization extends Service<Torganization>{
	public List<Torganization> get(int count);
}
