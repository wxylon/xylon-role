package org.role.service;

import java.util.List;

import org.role.pojo.Tgroup;
import org.role.service.base.Service;

public interface ITgroup extends Service<Tgroup>{
	public List<Tgroup> get(int count);
}
