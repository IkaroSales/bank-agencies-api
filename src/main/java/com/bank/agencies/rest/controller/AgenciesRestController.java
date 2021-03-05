package com.bank.agencies.rest.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.agencies.domain.AgencyGatewayResponse;
import com.bank.agencies.domain.AgencyResponse;
import com.bank.agencies.rest.api.AgenciesAPI;
import com.bank.agencies.usecase.FindAllAgenciesUseCase;

@RestController
@RequestMapping(value = "api/v1/agencies", produces = MediaType.APPLICATION_JSON_VALUE)
public class AgenciesRestController implements AgenciesAPI {

	private final Logger log = LoggerFactory.getLogger(AgenciesRestController.class);
	
	private final FindAllAgenciesUseCase findAllAgenciesUseCase;
	
	public AgenciesRestController(FindAllAgenciesUseCase findAllAgenciesUseCase) {
        this.findAllAgenciesUseCase = findAllAgenciesUseCase;
    }

	/**
	 * TODO: 
	 * 1. Perform pagination implementation to improve performance;
	 * 2. Cache the result by the found page;
	 * 3. Use the Spring Cloud Hystrix library to fallback requests;
	 * 4. Use compression to decrease data volume;
	 * 
	 * Get the agencies sorted by name and grouped by states
	 * @author Ikaro Sales <ifs.sales.12@gmail.com>
	 */
	@Override
	public ResponseEntity<Map<String, List<AgencyResponse>>> getTotalAgencies() {

		log.info("Requisition to obtain total agencies grouped by state");

		Optional<List<AgencyGatewayResponse>> getAllAgencies = Optional.ofNullable(findAllAgenciesUseCase.execute());

		if (!getAllAgencies.isPresent()) {
			log.error("Can't find agencies");

			return ResponseEntity.notFound().build();
		}

		log.info("Captured {} agencies", getAllAgencies.get().size());

		Map<String, List<AgencyResponse>> agenciesByState = mapAgenciesByState(getAllAgencies.get());

		log.info("Found {} state(s) in the search", agenciesByState.size());

		return ResponseEntity.ok(agenciesByState);
	}

	/**
	 * Create a mapping of agencies by states and sort by 'Name'
	 * @param agencies - Agency lists
	 * @author Ikaro Sales <ifs.sales.12@gmail.com>
	 */
	private Map<String, List<AgencyResponse>> mapAgenciesByState(List<AgencyGatewayResponse> agencies) {
		Map<String, List<AgencyResponse>> responseAgenciesByState = new HashMap<>();

		log.info("Mapping agencies by state...");

		Optional.ofNullable(agencies).orElseGet(Collections::emptyList).stream()
			.sorted((a1, a2) -> a1.getName().compareTo(a2.getName()))
			.forEach((AgencyGatewayResponse agencie) -> {

				AgencyResponse currentAgencie = AgencyResponse.builder()
						.name(agencie.getName())
						.city(agencie.getCity())
						.bank(agencie.getBank()).build();

				if (!responseAgenciesByState.containsKey(agencie.getState())) {
					List<AgencyResponse> tempAgencies = Arrays.asList(currentAgencie);

					responseAgenciesByState.put(agencie.getState(), new ArrayList<>(tempAgencies));
				} else {
					responseAgenciesByState.get(agencie.getState()).add(currentAgencie);
				}
			});

		return responseAgenciesByState;
	}
}
