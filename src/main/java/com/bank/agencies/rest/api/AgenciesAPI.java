package com.bank.agencies.rest.api;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import com.bank.agencies.domain.AgencyResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "CI&T - Agencies", produces = "REST API for CI&T", tags = { "Agencies" })
public interface AgenciesAPI {

	@ApiOperation(value = "Get agencies grouped by state", response = ApiResponse.class, tags = { "Agencies" })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successful", response = ApiResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = ApiResponse.class),
			@ApiResponse(code = 404, message = "Not found", response = ApiResponse.class)})
	@CrossOrigin
	@GetMapping
	public ResponseEntity<Map<String, List<AgencyResponse>>> getTotalAgencies();
}
