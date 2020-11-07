package com.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import com.dbutil.SQLConnection;

public class TimerDAOImpl implements TimerDAOLocale{

	private int i;

	@Override
	public List<Timer> getQuestions(Connection connection) {
		
				List<Timer> questions=new ArrayList<Timer>();
				System.out.println("in DAO getquestions");
			try{  
			
				Connection con=SQLConnection.getConnection();  
				String sql="select question from onlineshopping.test";
			PreparedStatement stmt=con.prepareStatement(sql);  
			
			ResultSet rs=stmt.executeQuery();
			Timer vw=new Timer();
			
			while(rs.next()) {
				
			 String q=(rs.getString("question"));
			  
			questions.add(q);
			
				System.out.println("records inserted");  
				
			}
			
				}catch(Exception e){ System.out.println(e);}
			return questions;
		
	}

	@Override
	public List<String> compare(Connection connection) {
		// TODO Auto-generated method stub
		List<String> ansrs=new ArrayList<String>();
		
		System.out.println("in DAO connection");
		try{  
			
			Connection con=SQLConnection.getConnection();  
			String sql="select ans from onlineshopping.test where questionno=";
		PreparedStatement stmt=con.prepareStatement(sql);  
		
		ResultSet rs=stmt.executeQuery();
		Timer vw=new Timer();
		
		while(rs.next()) {
				
		String s=(rs.getString("ans"));
		  
		 ansrs.add(s);
		
			System.out.println("records inserted");  
			
		}
			}catch(Exception e){ System.out.println(e);}
		return ansrs;
	
	}

}
