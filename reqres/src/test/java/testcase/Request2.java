package testcase;

import org.testng.Assert;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import EmployeeBasepakchage.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;

public class Request2 extends TestBase  {
	
//	public void  d()
//	{
//		abb();
//	}
	
	
	@BeforeClass
	public  void testingData()
	{
		logger.info("inside REQUEST2.JAVA ===== testing data checking data is there");
		RestAssured.baseURI ="https://reqres.in/";
		
		ht= 	RestAssured.given();
		
	res= 	ht.request(Method.GET,"/api/unknown/2");

	Assert.assertTrue(res.getBody().asString()!=null);

	//System.out.println(response.getBody().asString());


		
		
	}
	
	//TestBase.testingData();
	
	@Test(enabled = true)
	void checkdata()
	{
		logger.info("inside method check data checking the data");
	String n=	res.getBody().asString();
	Assert.assertTrue(n.contains("id")); 	;
	Assert.assertTrue(n.contains("name"))	;
	Assert.assertTrue (n.contains("year"))	;
	Assert.assertTrue (n.contains("color"))	;
	Assert.assertTrue(n.contains("pantone_value"));
	Assert.assertEquals(res.jsonPath().get("data.pantone_value"), "17-2031");
	Assert.assertEquals(res.jsonPath().get("data.id"), 2);

	}
	
	@Test(enabled = true)
	void printheader()
	{
	Headers h= 	res.headers();
	
	for(Header h1: h)
	{
		System.out.println(h1.getName()+ " " + h1.getValue());
	}
	
	
	}                   
		
	@Test(enabled =true)
	void checkstatuscode() {
		logger.info("checking status code to be 200");
		
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(enabled= false)
	void checktime()
	{
		logger.info("checking time taken ======");
		
		Assert.assertTrue(res.getTime() < 1000);
	}
	@AfterClass	
	void teardown()
	{
		logger.info("end of test cases");
		
		
	}
	

}