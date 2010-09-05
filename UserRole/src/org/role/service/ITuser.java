package org.role.service;

import java.util.List;

import org.role.pojo.Tuser;
import org.role.service.base.Service;

public interface ITuser extends Service<Tuser>{
	public List<Tuser> get(int count);
}
