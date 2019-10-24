package com.multifinance.service;

import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.multifinance.model.ResultModel;

public interface ResultService {

	public ResponseEntity<String> entryResult(ResultModel prodModel, String Authorization) throws JsonProcessingException;
	
	public ResponseEntity<String> getResultAll(String Authorization) throws JsonProcessingException;
	
	public ResponseEntity<String> getResultById(Integer id, String Authorization) throws JsonProcessingException;
	
	public ResponseEntity<String> updateResult(Integer id, ResultModel prodModel, String Authorization) throws JsonProcessingException;

	public ResponseEntity<String> deleteResult(Integer id, String Authorization) throws JsonProcessingException;
}
