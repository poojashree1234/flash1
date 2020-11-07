package com.dao;

import java.sql.Connection;
import java.util.List;

import com.model.View;

public interface ViewTableDaoLocal {
	public List<View> retrieveAllViews(Connection connection);
	public boolean register(Connection connection,View vw);
	public boolean islogin(Connection connection, View vw);
}
