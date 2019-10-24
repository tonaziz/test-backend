package com.multifinance.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.multifinance.dao.ErrorResponseDao;
import com.multifinance.dao.ResultDao;
import com.multifinance.model.ResultModel;
import com.multifinance.model.StatusModel;
import com.multifinance.model.response.ErrorResponseModel;
import com.multifinance.service.ResultService;
import com.multifinance.util.CommonUtil;
import com.multifinance.util.ErrorResponseUtil;

@Service
public class ResultServiceImpl implements ResultService {

	@Autowired
	private ResultDao docuDao;

	@Autowired
	private ErrorResponseDao errorResponseDao;

	@Override
	public ResponseEntity<String> entryResult(ResultModel docuModel, String Authorization) throws JsonProcessingException {
		StatusModel docuResponse = new StatusModel();
		ErrorResponseModel errorResponseModel = new ErrorResponseModel();
		StringBuilder createJson = new StringBuilder();

		try {
			
			if (Authorization.equals("eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoyLCJleHAiOjE1MTU4MzY0OTZ9.D6x6kcwcM2Cq6A5i-RVqBbyDxao-F2ln1TuGBmQu4LQ")) {			
			List<ResultModel> docu = new ArrayList<>();
			String createdAt = docuDao.entryResult(docuModel);
			
			docuModel.setId(docuDao.getId());
			docuModel.setCreatedAt(createdAt);
			docuModel.setUpdatedAt(createdAt);

			docu.add(docuModel);

			docuResponse.setStaus("OK");
			docuResponse.setResult(docu);

			createJson.append(CommonUtil.removeBracket(CommonUtil.modelToString(docuResponse)));
			return new ResponseEntity<>(CommonUtil.createBracket(createJson.toString()), HttpStatus.OK);
			} else {
				errorResponseModel = errorResponseDao.getErrorMessage("ER-0003");
				return new ResponseEntity<>(CommonUtil.modelToString(errorResponseModel),
						ErrorResponseUtil.getHttpStat(errorResponseModel.getStatus()));
			}
		} catch (Exception e) {
			e.printStackTrace();
			errorResponseModel = errorResponseDao.getErrorMessage("ER-0001");
			return new ResponseEntity<>(CommonUtil.modelToString(errorResponseModel),
					ErrorResponseUtil.getHttpStat(errorResponseModel.getStatus()));
		}

	}

	@Override
	public ResponseEntity<String> getResultAll(String Authorization) throws JsonProcessingException {
		StatusModel docuResponse = new StatusModel();
		
		ErrorResponseModel errorResponseModel = new ErrorResponseModel();

		try {
			if (Authorization.equals("eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoyLCJleHAiOjE1MTU4MzY0OTZ9.D6x6kcwcM2Cq6A5i-RVqBbyDxao-F2ln1TuGBmQu4LQ")) {			
			List<ResultModel> docu = docuDao.getResultAll();
			if (!docu.isEmpty()) {
				
				docuResponse.setStaus("OK");
				docuResponse.setResult(docu);
				return new ResponseEntity<>(CommonUtil.modelToString(docuResponse), HttpStatus.OK);
			} else {
				return null;
			}
			} else {
				errorResponseModel = errorResponseDao.getErrorMessage("ER-0003");
				return new ResponseEntity<>(CommonUtil.modelToString(errorResponseModel),
						ErrorResponseUtil.getHttpStat(errorResponseModel.getStatus()));
			}
		} catch (Exception e) {
			e.printStackTrace();
			errorResponseModel = errorResponseDao.getErrorMessage("ER-0001");
			return new ResponseEntity<>(CommonUtil.modelToString(errorResponseModel),
					ErrorResponseUtil.getHttpStat(errorResponseModel.getStatus()));
		}
	}

	@Override
	public ResponseEntity<String> getResultById(Integer id, String Authorization) throws JsonProcessingException {
		ErrorResponseModel errorResponseModel = new ErrorResponseModel();
		StatusModel docuResponse = new StatusModel();
		try {
			if (Authorization.equals("eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoyLCJleHAiOjE1MTU4MzY0OTZ9.D6x6kcwcM2Cq6A5i-RVqBbyDxao-F2ln1TuGBmQu4LQ")) {			
				if (docuDao.idCheck(id) != 0) {
				List<ResultModel> docu = new ArrayList<>();
				ResultModel docuModel = docuDao.getResultById(id);
				
				docu.add(docuModel);
				docuResponse.setStaus("OK");
				docuResponse.setResult(docu);
				
				return new ResponseEntity<>(CommonUtil.modelToString(docuResponse), HttpStatus.OK);
			} else {
				errorResponseModel = errorResponseDao.getErrorMessage("ER-0002");
				return new ResponseEntity<>(CommonUtil.modelToString(errorResponseModel),
						ErrorResponseUtil.getHttpStat(errorResponseModel.getStatus()));
			}
			} else {
				errorResponseModel = errorResponseDao.getErrorMessage("ER-0003");
				return new ResponseEntity<>(CommonUtil.modelToString(errorResponseModel),
						ErrorResponseUtil.getHttpStat(errorResponseModel.getStatus()));
			}
		} catch (Exception e) {
			e.printStackTrace();
			errorResponseModel = errorResponseDao.getErrorMessage("ER-0001");
			return new ResponseEntity<>(CommonUtil.modelToString(errorResponseModel),
					ErrorResponseUtil.getHttpStat(errorResponseModel.getStatus()));
		}
	}

	@Override
	public ResponseEntity<String> updateResult(Integer id, ResultModel docuModel, String Authorization) throws JsonProcessingException {
		ErrorResponseModel errorResponseModel = new ErrorResponseModel();
		StringBuilder createJson = new StringBuilder();
		StatusModel docuResponse = new StatusModel();
		try {
			if (Authorization.equals("eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoyLCJleHAiOjE1MTU4MzY0OTZ9.D6x6kcwcM2Cq6A5i-RVqBbyDxao-F2ln1TuGBmQu4LQ")) {			
				if (docuDao.idCheck(id) == 0) {
				errorResponseModel = errorResponseDao.getErrorMessage("ER-0002");
				return new ResponseEntity<>(CommonUtil.modelToString(errorResponseModel),
						ErrorResponseUtil.getHttpStat(errorResponseModel.getStatus()));
			}
			List<ResultModel> docu = new ArrayList<>();
			
			docuDao.updateResult(id, docuModel);
			docuModel = docuDao.getResultById(id);

			docu.add(docuModel);
			docuResponse.setStaus("OK");
			docuResponse.setResult(docu);

			createJson.append(CommonUtil.removeBracket(CommonUtil.modelToString(docuResponse)));
			return new ResponseEntity<>(CommonUtil.createBracket(createJson.toString()), HttpStatus.OK);
			
			} else {
				errorResponseModel = errorResponseDao.getErrorMessage("ER-0003");
				return new ResponseEntity<>(CommonUtil.modelToString(errorResponseModel),
						ErrorResponseUtil.getHttpStat(errorResponseModel.getStatus()));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			errorResponseModel = errorResponseDao.getErrorMessage("AQ-EP012");
			return new ResponseEntity<>(CommonUtil.modelToString(errorResponseModel),
					ErrorResponseUtil.getHttpStat(errorResponseModel.getStatus()));
		}
	}
	
	public ResponseEntity<String> deleteResult(Integer id, String Authorization) throws JsonProcessingException{
		ErrorResponseModel errorResponseModel = new ErrorResponseModel();
		StringBuilder createJson = new StringBuilder();
		StatusModel docuResponse = new StatusModel();
		try {
			if (Authorization.equals("eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoyLCJleHAiOjE1MTU4MzY0OTZ9.D6x6kcwcM2Cq6A5i-RVqBbyDxao-F2ln1TuGBmQu4LQ")) {			
				if (docuDao.idCheck(id) == 0) {
				errorResponseModel = errorResponseDao.getErrorMessage("ER-0002");
				return new ResponseEntity<>(CommonUtil.modelToString(errorResponseModel),
						ErrorResponseUtil.getHttpStat(errorResponseModel.getStatus()));
			}
			List<ResultModel> docu = new ArrayList<>();
			
			docuDao.deleteResult(id);
			ResultModel docuModel = new ResultModel();
			
			docuModel.setMessage(String.valueOf(id) + " deleted");

			docu.add(docuModel);
			docuResponse.setStaus("OK");
			docuResponse.setResult(docu);

			createJson.append(CommonUtil.removeBracket(CommonUtil.modelToString(docuResponse)));
			return new ResponseEntity<>(CommonUtil.createBracket(createJson.toString()), HttpStatus.OK);
			
			} else {
				errorResponseModel = errorResponseDao.getErrorMessage("ER-0003");
				return new ResponseEntity<>(CommonUtil.modelToString(errorResponseModel),
						ErrorResponseUtil.getHttpStat(errorResponseModel.getStatus()));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			errorResponseModel = errorResponseDao.getErrorMessage("AQ-EP012");
			return new ResponseEntity<>(CommonUtil.modelToString(errorResponseModel),
					ErrorResponseUtil.getHttpStat(errorResponseModel.getStatus()));
		}
	}

}
