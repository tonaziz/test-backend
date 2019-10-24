package com.multifinance.model.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.multifinance.model.ResultModel;

@JsonInclude(Include.NON_EMPTY)
public class DocuList {

	private List<ResultModel> documentTemplateDifinition;

	public DocuList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DocuList(List<ResultModel> documentTemplateDifinition) {
		super();
		this.documentTemplateDifinition = documentTemplateDifinition;
	}

	public List<ResultModel> getDocumentTemplateDifinition() {
		return documentTemplateDifinition;
	}

	public void setDocumentTemplateDifinition(List<ResultModel> documentTemplateDifinition) {
		this.documentTemplateDifinition = documentTemplateDifinition;
	}

}
