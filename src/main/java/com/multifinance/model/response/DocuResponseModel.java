package com.multifinance.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class DocuResponseModel {

	private String docuCateId;
	private String response;

	public DocuResponseModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DocuResponseModel(String docuCateId, String response) {
		super();
		this.docuCateId = docuCateId;
		this.response = response;
	}

	public String getDocuCateId() {
		return docuCateId;
	}

	public void setDocuCateId(String docuCateId) {
		this.docuCateId = docuCateId;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
}