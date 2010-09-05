package org.role.dao.impl;

import org.role.dao.TuserDAO;
import org.role.dao.base.DAOSupport;
import org.role.pojo.Tuser;
import org.springframework.stereotype.Repository;

@Repository("tuserDAO")
public class TuserDAOImpl extends DAOSupport<Tuser> implements TuserDAO {

}
