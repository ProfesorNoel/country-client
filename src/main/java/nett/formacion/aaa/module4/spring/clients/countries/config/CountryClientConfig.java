package nett.formacion.aaa.module4.spring.clients.countries.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import nett.formacion.aaa.module4.spring.clients.countries.CountryClient;

@Configuration
public class CountryClientConfig {

	private final static String WSDL_URI = "http://localhost:6099/ws/countries.wsdl";
	
	public CountryClientConfig() 
	{
		super();
	}
	
	@Bean
	public Jaxb2Marshaller marshaller() 
	{
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("nett.formacion.aaa.module4.spring.clients.countries.wsdl");
		
		return marshaller;
	}
	
	@Bean
	public CountryClient countryClient(Jaxb2Marshaller marshaller) 
	{
		CountryClient client = new CountryClient();
		
		client.setDefaultUri(CountryClientConfig.WSDL_URI);
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		
		return client;
	}
	
}