package com.dsoft.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.dsoft.dao.DaoManger;

public class DaoServicess {
	@Autowired
	private DaoManger daoManager = null;

	public DaoManger getDaoManager() {
		return daoManager;
	}

	public void setDaoManager(DaoManger daoManager) {
		this.daoManager = daoManager;
	}
}
