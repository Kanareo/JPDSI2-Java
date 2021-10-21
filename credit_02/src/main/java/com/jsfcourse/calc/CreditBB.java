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
	private String a; //kwota
	private String p; //oprocentowanie
	private String y; //ilosc lat
	private Double result;
	private Double fullResult;

	@Inject
	FacesContext ctx;

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getP() {
		return p;
	}

	public void setP(String p) {
		this.p = p;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
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
		try {
			
			double a = Double.parseDouble(this.a);
			double p = Double.parseDouble(this.p);
			double y = Double.parseDouble(this.y);
			
			result = a*((100+p)/100)/(y*12);
			fullResult = result*(y*12);

			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacja wykonana poprawnie", null));
			return true;
		} catch (Exception e) {
			ctx.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd podczas przetwarzania parametrów", null));
			return false;
		}
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
