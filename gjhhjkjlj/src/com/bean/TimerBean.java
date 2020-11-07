package com.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;

import javax.ejb.TimerService;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UISelectItem;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlSelectOneRadio;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

@ManagedBean
	@SessionScoped
	public class TimerBean {
	    private int questionno;
	    private String question;
	   
		private String opt1;
	    private String opt2;
	    private String opt3; 
	    private String opt4;
	    private String ans;
	    private String select;
	    int count=0;
	    private String str;
	    private int value1;
		public int getQuestionno() {
			return questionno;
		}
		public void setQuestionno(int questionno) {
			this.questionno = questionno;
		}
		public String getOpt1() {
			return opt1;
		}
		public void setOpt1(String opt1) {
			this.opt1 = opt1;
		}
		public String getOpt2() {
			return opt2;
		}
		public void setOpt2(String opt2) {
			this.opt2 = opt2;
		}
		public String getOpt3() {
			return opt3;
		}
		public void setOpt3(String opt3) {
			this.opt3 = opt3;
		}
		public String getOpt4() {
			return opt4;
		}
		public void setOpt4(String opt4) {
			this.opt4 = opt4;
		}
		public String getAns() {
			return ans;
		}
		public void setAns(String ans) {
			this.ans = ans;
		}
		public String getSelect() {
			return select;
		}
		public void setSelect(String select) {
			this.select = select;
		}
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		public String getStr() {
			return str;
		}
		public void setStr(String str) {
			this.str = str;
		}
		public int getValue1() {
			return value1;
		}
		public void setValue1(int value1) {
			this.value1 = value1;
		}



		 public String getQuestion() {
				return question;
			}
			public void setQuestion(String question) {
				this.question = question;
			}

		@Inject
		private com.service.timerService timerService;  

	   public List<Timer> getQuestions(){
		   List<Timer> questions=new ArrayList<Timer>();
		   questions=timerService.getQuestions();
		   return questions;
	   }
	   public void compare() {
		   String i="";
		   i=timerService.compare();
		   if(i.equalsIgnoreCase(str)) {
			   setValue1(count++);
			   System.out.println(count+"with count");
		   }
		   else {
			   value1=count;
			   System.out.println(count+"without count");
		   }
	   }
	}
