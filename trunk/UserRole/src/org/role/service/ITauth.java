package org.role.service;

import java.util.List;

import org.role.pojo.Tauth;
import org.role.service.base.Service;

public interface ITauth extends Service<Tauth>{
	public List<Tauth> get(int count);
}
