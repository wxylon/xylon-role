package org.role.dao.impl;

import org.role.dao.TlogDAO;
import org.role.dao.base.DAOSupport;
import org.role.pojo.Tlog;
import org.springframework.stereotype.Repository;

@Repository("tlogDAO")
public class TlogDAOImpl extends DAOSupport<Tlog> implements TlogDAO {

}
