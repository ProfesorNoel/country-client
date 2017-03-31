package nett.formacion.aaa.module4.spring.clients.countries;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ch.qos.logback.core.net.server.Client;
import nett.formacion.aaa.module4.spring.clients.countries.config.CountryClientConfig;
import nett.formacion.aaa.module4.spring.clients.countries.wsdl.Country;
import nett.formacion.aaa.module4.spring.clients.countries.wsdl.GetCountryResponse;

@SpringBootApplication
public class CountryClientApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(CountryClientApplication.class);
	
	private static final String countryDefault = "Spain";
	
	@Autowired
	
	
	public static void main(String[] args) {
		SpringApplication.run(CountryClientApplication.class, args);
		
		LOGGER.info("Starting main method....");
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(CountryClientConfig.class);
        ctx.refresh();
        
        CountryClient client = ctx.getBean(CountryClient.class);
		
        GetCountryResponse response = client.getCountryByName(CountryClientApplication.countryDefault);
		
        Country c = response.getCountry();
		
		if (c != null)
		{
			LOGGER.info("Country: " + c.getName() + " - Capital: " + c.getCapital() +
				" - Population: " + c.getPopulation() + " - Currency: " + c.getCurrency());
		}
		else
		{
			LOGGER.info("None country available");
		}
		
	}
}
