package com.bank.agencies.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.agencies.domain.AgencyGatewayResponse;
import com.bank.agencies.external.gateway.AgenciesGateway;

@Service
public class FindAllAgenciesUseCase {

	@Autowired
    private final AgenciesGateway bankResourcesGateway;

    public FindAllAgenciesUseCase(AgenciesGateway bankResourcesGateway) {
        this.bankResourcesGateway = bankResourcesGateway;
    }

    public List<AgencyGatewayResponse> execute() {
        return bankResourcesGateway.findAllAgencies();
    }
}
