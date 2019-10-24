package com.multifinance.dao;

import java.util.List;

import com.multifinance.model.ResultModel;

public interface ResultDao {

	String entryResult(ResultModel docuModel);
	
	List<ResultModel> getResultAll();

	ResultModel getResultById(Integer id);
	
	int updateResult(Integer id, ResultModel docuModel);
	
	void closeSession();
	
	int deleteResult(Integer id);

	int idCheck(Integer id);

	Integer getId();
}
