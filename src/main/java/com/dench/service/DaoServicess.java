package com.dench.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.dench.dao.DaoManger;

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
