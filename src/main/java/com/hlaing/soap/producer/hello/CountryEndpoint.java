package com.hlaing.soap.producer.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.spring.guides.gs_producing_web_service.GetCountryRequest;
import io.spring.guides.gs_producing_web_service.GetCountryResponse;

@Endpoint
public class CountryEndpoint {

	private static final String NAMESPAC_URI = "http://spring.io/guides/gs-producing-web-service";
	
	private CountryRepository countryRepository;
	
	@Autowired
	public CountryEndpoint(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}
	
	@PayloadRoot(namespace = NAMESPAC_URI, localPart = "getCountryRequest")
	@ResponsePayload
	public GetCountryResponse getCountry(@RequestPayload GetCountryRequest requset) {
		
		GetCountryResponse resp = new GetCountryResponse();
		resp.setCountry(countryRepository.findCountry(requset.getName()));
		
		return resp;
	}
}
