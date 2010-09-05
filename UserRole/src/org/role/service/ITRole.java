package org.role.service;

import java.util.List;
import org.role.pojo.Trole;
import org.role.service.base.Service;

public interface ITRole extends Service<Trole>{
	public List<Trole> get();
}
