package com.multifinance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.multifinance.model.ResultModel;
import com.multifinance.service.ResultService;

@CrossOrigin(origins = "*")
@RestController
public class ResultController {

	@Autowired
	private ResultService docuService;

	@PostMapping(path = "private-anon-2a283d0eb9-testbinar.apiary-proxy.com/v1/products", produces = "application/json")
	public ResponseEntity<String> entryResult(@RequestBody ResultModel docuModel, @RequestHeader String Authorization) throws JsonProcessingException {
		return docuService.entryResult(docuModel, Authorization);
	}

	@GetMapping(path = "private-anon-2a283d0eb9-testbinar.apiary-proxy.com/v1/products", produces = "application/json")
	public ResponseEntity<String> getResultAll( @RequestHeader String Authorization) throws JsonProcessingException {
		return docuService.getResultAll(Authorization);
	}

	@GetMapping(path = "private-anon-2a283d0eb9-testbinar.apiary-proxy.com/v1/products/{id}", produces = "application/json")
	public ResponseEntity<String> getResultById(@PathVariable Integer id,  @RequestHeader String Authorization) throws JsonProcessingException {
		return docuService.getResultById(id, Authorization);
	}

	@PutMapping(path = "private-anon-2a283d0eb9-testbinar.apiary-proxy.com/v1/products/{id}", produces = "application/json")
	public ResponseEntity<String> updateResult(@RequestBody ResultModel docuModel, @PathVariable Integer id,  @RequestHeader String Authorization)
			throws JsonProcessingException {
		return docuService.updateResult(id, docuModel, Authorization);
	}

	@DeleteMapping(path = "private-anon-2a283d0eb9-testbinar.apiary-proxy.com/v1/products/{id}", produces = "application/json")
	public ResponseEntity<String> deleteResult(@PathVariable Integer id,  @RequestHeader String Authorization)
			throws JsonProcessingException {
		return docuService.deleteResult(id, Authorization);
	}

}
