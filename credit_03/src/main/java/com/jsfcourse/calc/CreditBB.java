package com.jsfcourse.calc;

import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named
@RequestScoped

public class CreditBB {
	private Integer a; //kwota
	private Double p; //oprocentowanie
	private Integer y; //ilosc lat
	private Double result;
	private Double fullResult;

	@Inject
	FacesContext ctx;

	public Integer getA() {
		return a;
	}

	public void setA(Integer a) {
		this.a = a;
	}

	public Double getP() {
		return p;
	}

	public void setP(Double p) {
		this.p = p;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}
	
	public Double getFullResult() {
		return fullResult;
	}

	public void setFullResult(Double result) {
		this.result = fullResult;
	}

	public boolean calculate() {		
			result = a*((100+p)/100)/(y*12);
			fullResult = result*(y*12);

			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacja wykonana poprawnie", null));
			return true;
	}

	public String calc() {
		if (calculate()) {
			return "showresult";
		}
		return null;
	}

	public String info() {
		return "info";
	}
}
