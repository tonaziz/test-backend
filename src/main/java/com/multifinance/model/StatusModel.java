package com.multifinance.model;

import java.util.List;

public class StatusModel {

	private String staus;
	private List<ResultModel> result;
	private List<String> errors[];

	public StatusModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getStaus() {
		return staus;
	}

	public void setStaus(String staus) {
		this.staus = staus;
	}

	public List<ResultModel> getResult() {
		return result;
	}

	public void setResult(List<ResultModel> result) {
		this.result = result;
	}

	public List<String>[] getErrors() {
		return errors;
	}

	public void setErrors(List<String>[] errors) {
		this.errors = errors;
	}

}
