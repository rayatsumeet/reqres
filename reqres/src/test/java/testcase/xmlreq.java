package testcase;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import EmployeeBasepakchage.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class xmlreq extends TestBase  {
	
	
	@Test
	public void buildRequest()
	{
		logger.info("starting XML REQ");
		RestAssured.baseURI="http://webservices.oorsprong.org/websamples.countryinfo";
		
		ht= 	RestAssured.given();
		String b= "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://www.oorsprong.org/websamples.countryinfo\">\r\n" + 
				"   <soapenv:Header/>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <web:CapitalCity>\r\n" + 
				"         <web:sCountryISOCode>IND</web:sCountryISOCode>\r\n" + 
				"      </web:CapitalCity>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
		ht.header("Content-Type","text/xml");
		ht.body(b);
		
		
		
		res=	ht.request(Method.POST, "/CountryInfoService.wso?wsdl");
		
		Assert.assertTrue(res.getBody().asString()!=null);
		System.out.println(res.getBody().asString());
		
	}
	
	@Test(enabled=true)
	public void validate()
	{
		String a = res.getBody().asString();
		Assert.assertTrue(a.contains("New Delhi"));
		System.out.println(res.xmlPath().get("//soap:Body/m:CapitalCityResponse/m:CapitalCityResult"));
	//	Assert.assertTrue(response.xmlPath().get("//soap:Body/m:CapitalCityResponse/m:CapitalCityResult").equals("New Delhi"));
		
		Assert.assertEquals(res.xmlPath().get("//soap:Body/m:CapitalCityResponse/m:CapitalCityResult").toString(), "New Delhi");
	}

}