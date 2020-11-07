package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dbutil.SQLConnection;
import com.model.View;


public class ViewTableDao implements ViewTableDaoLocal {
	 @Override
	public List<View> retrieveAllViews(Connection connection){
		List<View> Car=new ArrayList<View>();
		System.out.println("in DAO");
	try{  
	
		Connection con=SQLConnection.getConnection();  
		String sql="select * from onlineshopping.view";
	PreparedStatement stmt=con.prepareStatement(sql);  
	
	ResultSet rs=stmt.executeQuery();
	View vw=new View();
	while(rs.next()) {
	 vw.setId(rs.getString("id"));
	vw.setBrand(rs.getString("brand"));
	vw.setColor(rs.getString("color"));
	vw.setPrice(rs.getString("price"));	  
	Car.add(vw);
		System.out.println("records inserted");  
		
	}
		}catch(Exception e){ System.out.println(e);}
	return Car;  
}
	
	@Override
	public boolean register( Connection connection,View vw) {
		boolean b=false;
		int res=0;
		try {
			PreparedStatement prep=connection.prepareStatement("insert into onlineshopping.view(id,brand,color,price,name,password)values(?,?,?,?,?,?)");
			prep.setString(1, vw.getId());
			prep.setString(2, vw.getBrand());
			prep.setString(3, vw.getColor());
			prep.setString(4, vw.getPrice());
			prep.setString(5, vw.getName());
			prep.setString(6, vw.getPassword());
			res=prep.executeUpdate();
			if(res!=0)
				b=true;
		}
		catch (Exception e) {
			System.out.println(e);
		}
	
		return b;
	}

	@Override
	public boolean islogin(Connection connection, View vw) {
		boolean b=false;
		try{  
			
			Connection con=SQLConnection.getConnection();  
			String sql="select * from onlineshopping.view where name=?";
		PreparedStatement stmt=con.prepareStatement(sql);  
		stmt.setString(1, vw.getName());
		ResultSet rs=stmt.executeQuery();
		
		while(rs.next()) {
		 vw.setId(rs.getString("name"));
	
		vw.setPrice(rs.getString("password"));
		
			System.out.println("successful login");
			b=true;
		}
		
			}catch(Exception e){ System.out.println(e);}
		return b;
	}
	
}