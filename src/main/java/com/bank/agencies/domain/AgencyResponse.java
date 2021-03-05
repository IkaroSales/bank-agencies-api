package com.bank.agencies.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include. NON_NULL)
public class AgencyResponse implements Serializable {

    private static final long serialVersionUID = -7394339763238481398L;

    private String name;
    private String bank;
    private String city;
    private String state;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public static final AgencyResponseBuilder builder() {
    	return new AgencyResponseBuilder();
    }

    public static final class AgencyResponseBuilder {
        private String name;
        private String bank;
        private String city;
        private String state;

        private AgencyResponseBuilder() { }

        public static AgencyResponseBuilder anAgencyResponse() {
            return new AgencyResponseBuilder();
        }

        public AgencyResponseBuilder name(String name) {
            this.name = name;
            return this;
        }

        public AgencyResponseBuilder bank(String bank) {
            this.bank = bank;
            return this;
        }

        public AgencyResponseBuilder city(String city) {
            this.city = city;
            return this;
        }

        public AgencyResponseBuilder state(String state) {
            this.state = state;
            return this;
        }

        public AgencyResponse build() {
            AgencyResponse agencyResponse = new AgencyResponse();
            agencyResponse.setName(name);
            agencyResponse.setBank(bank);
            agencyResponse.setCity(city);
            agencyResponse.setState(state);
            return agencyResponse;
        }
    }
}

