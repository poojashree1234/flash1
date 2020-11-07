package com.ejb;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import com.dao.TimerDAOImpl;
import com.dao.TimerDAOLocale;
import com.dao.ViewTableDao;
import com.dao.ViewTableDaoLocal;
import com.dbutil.SQLConnection;
import com.model.View;

public class TimerEJBimpl implements TimeEJBLocale {

	@Override
	public List<Timer> getQuestions() {
		{
			 
			List<Timer> questions=new ArrayList<Timer>();
				Connection connection;
				try {
					connection= SQLConnection.getConnection();
				
	              TimerDAOLocale timerdao=new TimerDAOImpl();
	              questions= timerdao.getQuestions(connection);
				
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return questions;
	}
	
	}

	@Override
	public List<String> compare() {
		List<String> ansrs=new ArrayList<String>();
Connection connection;
try {
	connection= SQLConnection.getConnection();

  TimerDAOLocale timerdao=new TimerDAOImpl();
  ansrs= timerdao.compare(connection);

} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
return ansrs;
	}
	
}
