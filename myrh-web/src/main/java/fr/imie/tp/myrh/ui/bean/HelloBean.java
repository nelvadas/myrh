package fr.imie.tp.myrh.ui.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="imieBean")
public class HelloBean {
	
	
	private String value = "Welcome to IMIE Java Course";

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	

}
