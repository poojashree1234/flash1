package com.bean;



import java.io.IOException;

 
import java.util.List;
import java.util.Map;


import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.event.SelectEvent;

import com.model.View;
import com.service.ViewService;


@SuppressWarnings("deprecation")
 
@ManagedBean(name="CarList")
 
public class ViewBean {
 


private Map<String,Object> sessionMap=FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

private List<View> cars;

private View selectedCar;
private View view;

@Inject
private ViewService viewService;

private String id;

private String brand;

private String color;
 private String  price;
  
 private String name;
 private String password;

public Map<String, Object> getSessionMap() {
	return sessionMap;
}


public void setSessionMap(Map<String, Object> sessionMap) {
	this.sessionMap = sessionMap;
}


public String getId() {
	return id;
}


public void setId(String id) {
	this.id = id;
}


public String getBrand() {
	return brand;
}


public void setBrand(String brand) {
	this.brand = brand;
}


public String getColor() {
	return color;
}


public void setColor(String color) {
	this.color = color;
}


public String getPrice() {
	return price;
}


public void setPrice(String price) {
	this.price = price;
}



public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}


public View getSelectedCar() {
	return selectedCar;
}


public void setSelectedCar(View selectedCar) {
	this.selectedCar = selectedCar;
}


public ViewService getViewService() {
	return viewService;
}


public void setViewService(ViewService viewService) {
	this.viewService = viewService;
}



public List<View> getCars() {
	cars = viewService.retrieveAllViews();
	return cars;
}


public void setCars(List<View> cars) {
	this.cars = cars;
}


public View getView() {
	return view;
}


public void setView(View view) {
	
	this.view = view;
}
 
	  public void onRowSelect(SelectEvent event) 
	  {  
		  ViewBean vie=new   ViewBean();
		  
		  System.out.println(((View) event.getObject()).getId());
		   
		 vie.view.setId(((View) event.getObject()).getId());
		   
		 vie.view.setBrand(((View) event.getObject()).getBrand());
		   
		 vie.view.setColor(((View) event.getObject()).getColor());
		   
		
		   vie.view.setPrice(((View) event.getObject()).getPrice());
		 
		sessionMap.put("bnm",vie);

		  try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("detail.xhtml?faces_redirect=true");
		} 
		  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	  }
	  public void  row()
	  {
		  
		  View vwio=new View();
		  vwio.setId(this.id);
		
		vwio.setBrand(this.brand);
		  
		vwio.setColor(this.color);
		
		vwio.setPrice(this.price);

		  try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("datatable.xhtml?faces_redirect=true");
		} 
		  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
public String register() {
	boolean b=false;
	View vw=new View();
	vw.setId(this.id);
	System.out.println(vw.getId()+" in bean");
	vw.setBrand(this.brand);
	vw.setColor(this.color);
	vw.setPrice(this.price);
	vw.setName(this.name);
	vw.setPassword(this.password);
	b=viewService.register(vw);
	if(b)
		return "login.xhtml";
	return "datatable.xhtml";
	}

public String islogin() {
	boolean b=false;
	View vw=new View();
	System.out.println("in bean login");
	
	vw.setName(getName());
	System.out.println(vw.getName()+"insise lgin");
	vw.setPassword(this.password);
	b=viewService.islogin(vw);
	if(b) {
	return "datatable.xhtml";
	
		
	}
	else
	return "datatable.xhtml";
}
}


	 

