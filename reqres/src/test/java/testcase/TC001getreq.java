package testcase;




import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import EmployeeBasepakchage.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;


public class TC001getreq extends TestBase {
	
	@BeforeClass
	void getresponse()  {
		logger.info("*********  started TC001_Get_All_Employees **********");
		System.out.println("inside");
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		
		
		ht= RestAssured.given();
		
		res= ht.request(Method.GET,"/employees");
		
		String r = res.getBody().asString();
		System.out.println(r);
		Assert.assertTrue(r!=null);
		
	}
	
	

	
	@Test
	void checkResponseTime()
	{
		try {
			logger.info("***********  Checking Response time **********");
			int a =  res.getStatusCode();
			System.out.println(a);
			Assert.assertEquals(a, 200);
		} catch (Exception e) {
			logger.info("exception occured");
			e.printStackTrace();
		}

		
			
	}
	
	@Test
	void checkContentType()
	{
		try {
			logger.info("***********  Checking Content Type **********");
			
			String contentType = res.header("Content-Type");
			logger.info("Content type is ==>" + contentType);
			Assert.assertEquals(contentType, "application/json;charset=utf-8");
			
		} catch (Exception e) {
			logger.info("exception occured");
			e.printStackTrace();
		}
	
	}
	
	@AfterClass
	void tearDown()
	{
		try {
			logger.info("*********  Finished TC001_Get_All_Employees **********");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
