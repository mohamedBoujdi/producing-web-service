package com.example.producingwebservice;

import io.spring.guides.gs_producing_web_service.GetCountryRequest;
import io.spring.guides.gs_producing_web_service.GetCountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

public class CountryEndpoint {
    //we use the @Endpoint annotation to mark this class as a web service endpoint
    private static final String NAMESPACE_URI="http://spring.io/guides/gs-producing-web-service";
    private CountryRepository countryRepository;

    @Autowired //this annotation is used to inject the bean dependency
    //we add the @Autowired annotation to the constructor to tell Spring to inject the CountryRepository dependency
    public CountryEndpoint(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    //we use the @PayloadRoot annotation to map the incoming SOAP message to the getCountry method
    @ResponsePayload //we use the @ResponsePayload annotation to tell Spring to map the return value to the response payload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countryRepository.findCountry(request.getName()));
        return response;
    }


}
