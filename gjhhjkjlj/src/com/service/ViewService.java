package com.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.ejb.ViewTableEJBLocal;
import com.model.View;

@SuppressWarnings({ "serial", "deprecation" })

@ManagedBean

	
	public class ViewService implements Serializable{

		@EJB
		public ViewTableEJBLocal viewTableEJB; 
		
		
		public List<View> retrieveAllViews(){
			return viewTableEJB.retrieveAllViews();
			
		}
		

		public boolean register(View vw) {
			boolean b=false;
			
					b=viewTableEJB.register(vw);
					System.out.println(b+" inside service");
					return b;
			
		}
		
		public boolean islogin(View vw) {
			boolean b=false;
			 b=viewTableEJB.islogin(vw);
			return b;
		}
		
	}


