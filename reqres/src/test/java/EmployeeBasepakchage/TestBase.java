package EmployeeBasepakchage;



import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.apache.log4j.Level;

import org.apache.log4j.Logger;

import org.apache.log4j.PropertyConfigurator;

public class TestBase {
	
	
public static RequestSpecification ht;

public static Response res;
	
public  String id="7"; //Hard coded - Input for Get details of Single Employee & update employee
	
	
	
public Logger logger;
	

	
@BeforeClass(enabled = true)
public void setup(){
	
	//logger object
	logger=Logger.getLogger("EmployeeBasepakchage");//added Logger
	
	PropertyConfigurator.configure("log4j.properties"); //added logger
		
        logger.setLevel(Level.DEBUG);
		

	}


}
