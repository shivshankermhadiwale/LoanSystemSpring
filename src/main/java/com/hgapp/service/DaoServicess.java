package com.hgapp.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.hgapp.dao.DaoManger;

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
