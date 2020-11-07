package com.ejb;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.dao.ViewTableDao;
import com.dao.ViewTableDaoLocal;
import com.dbutil.SQLConnection;
import com.model.View;

@Stateless(mappedName = "ViewTableEJB")
@LocalBean

	
	public class ViewTableEJB extends SQLConnection  implements ViewTableEJBLocal{

		
		// Creating Connections
		// Business Logic / Functionality needs
		// Mach5 or Hattrick Application

		      @Override
		
		        public List<com.model.View> retrieveAllViews()
		      {
				 
				List<View> Car=new ArrayList<View>();
    				Connection connection;
					try {
						connection= SQLConnection.getConnection();
					
		              ViewTableDaoLocal viewdao=new ViewTableDao();
		              Car= viewdao.retrieveAllViews(connection);
					
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

			return Car;

				}
		      
			@Override
			public boolean register(View vw) {
				boolean b=false;
				Connection connection;
				try {
					connection = SQLConnection.getConnection();
				
	              ViewTableDaoLocal viewdao=new ViewTableDao();
	              b=viewdao.register(connection, vw);
	              System.out.println(b+" inside ejb");
	              
	              
				
			}catch (Exception e) {
				System.out.println(e);
			}
				return b;

		}

			@Override
			public boolean islogin(View vw) {
				boolean b=false;
				Connection connection;
				try {
					connection = SQLConnection.getConnection();
				
	              ViewTableDaoLocal viewdao=new ViewTableDao();
	              b=viewdao.islogin(connection, vw);
				
			}catch (Exception e) {
				System.out.println(e);
			}
				return b;
			}

}

