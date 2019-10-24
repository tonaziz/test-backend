package com.multifinance.dao;

import com.multifinance.model.response.ErrorResponseModel;

public interface ErrorResponseDao {
	
	public ErrorResponseModel getErrorMessage(String error);
}
