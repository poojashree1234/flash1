package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import javax.ejb.EJB;

import com.ejb.TimeEJBLocale;
import com.ejb.ViewTableEJBLocal;
import com.model.View;

public class timerService {
	@EJB
	public TimeEJBLocale timeEJBLocale; 
	
	
	public List<Timer> getQuestions(){
		return timeEJBLocale.getQuestions();
		
	}


	public List<String>  compare() {
		List<String> ansrs=new ArrayList<String>();
		return ansrs=timeEJBLocale.compare();
	}
	



}
