package com.ejb;

import java.util.List;

import javax.ejb.Local;

import com.model.View;

@Local
public interface ViewTableEJBLocal {

	

		public List<View> retrieveAllViews();
		public boolean register(View vw);
		
		public boolean islogin(View vw);
	}

