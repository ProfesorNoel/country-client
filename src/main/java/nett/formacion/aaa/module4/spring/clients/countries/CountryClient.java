package nett.formacion.aaa.module4.spring.clients.countries;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import nett.formacion.aaa.module4.spring.clients.countries.wsdl.GetCountryRequest;
import nett.formacion.aaa.module4.spring.clients.countries.wsdl.GetCountryResponse;

public class CountryClient extends WebServiceGatewaySupport {

	public CountryClient() 
	{
		super();
	}

	public GetCountryResponse getCountryByName(String country)
	{
		GetCountryResponse response = null;
		
		GetCountryRequest request = new GetCountryRequest();
		
		request.setName(country);
		
		response = (GetCountryResponse) this.getWebServiceTemplate().marshalSendAndReceive
				(request, new SoapActionCallback("http://localhost:6099/ws/getCountryResponse"));
				
		return response; 
	}
}
