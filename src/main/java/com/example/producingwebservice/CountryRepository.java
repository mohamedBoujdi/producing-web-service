package com.example.producingwebservice;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import io.spring.guides.gs_producing_web_service.Country;
import io.spring.guides.gs_producing_web_service.Currency;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class CountryRepository {
    private static final Map<String, Country> countries = new HashMap<>();
    @PostConstruct //this annotation is used to initialize the bean after its creation and dependency injection is done
    public void initData() {
        Country spain = new Country();
        spain.setName("Spain");
        spain.setCapital("Madrid");
        spain.setCurrency(Currency.EUR);
        spain.setPopulation(46704314);
        //countries.put(spain.getName(), spain);
        Country poland = new Country();
        poland.setName("Poland");
        poland.setCapital("Warsaw");
        poland.setCurrency(Currency.PLN);
        poland.setPopulation(38186860);
        //countries.put(poland.getName(), poland);
        Country germany = new Country();
        germany.setName("Germany");
        germany.setCapital("Berlin");
        germany.setCurrency(Currency.EUR);
        germany.setPopulation(81770900);
        //countries.put(germany.getName(), germany);
        Country france = new Country();
        france.setName("France");
        france.setCapital("Paris");
        france.setCurrency(Currency.EUR);
        france.setPopulation(64768389);
        //countries.put(france.getName(), france);
        Country italy = new Country();
        italy.setName("Italy");
        italy.setCapital("Rome");
        italy.setCurrency(Currency.EUR);
        italy.setPopulation(60795694);
        //countries.put(italy.getName(), italy);
        Country portugal = new Country();
        portugal.setName("Portugal");
        portugal.setCapital("Lisbon");
        portugal.setCurrency(Currency.EUR);
        portugal.setPopulation(10374822);
        //countries.put(portugal.getName(), portugal);
        Country morocco = new Country();
        morocco.setName("Morocco");
        morocco.setCapital("Rabat");
        morocco.setCurrency(Currency.MAD);
        morocco.setPopulation(33337529);
//countries.put(morocco.getName(), morocco);
        Country tunisia = new Country();
        tunisia.setName("Tunisia");
        tunisia.setCapital("Tunis");
        tunisia.setCurrency(Currency.TND);
        tunisia.setPopulation(11154400);
        //countries.put(tunisia.getName(), tunisia);
        Country algeria = new Country();
        algeria.setName("Algeria");
        algeria.setCapital("Algiers");
        algeria.setCurrency(Currency.DZD);
        algeria.setPopulation(40606052);
        //countries.put(algeria.getName(), algeria);
        Country libya = new Country();
        libya.setName("Libya");
        libya.setCapital("Tripoli");
        libya.setCurrency(Currency.LYD);
        libya.setPopulation(6385000);
        //countries.put(libya.getName(), libya);

        // putAll() added to java 8 Map interface

        countries.putAll(Map.of(spain.getName(), spain, poland.getName(), poland, germany.getName(), germany, france.getName(), france));
    }

    //findCountry() method
    public Country findCountry(String name) {
        Assert.notNull(name, "The country's name must not be null");
        return countries.get(name);
    }

}
