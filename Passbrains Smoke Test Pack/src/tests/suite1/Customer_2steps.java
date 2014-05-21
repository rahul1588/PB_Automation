package tests.suite1;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
//import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import tests.*;
import util.TestUtil;

@RunWith(Parameterized.class)
public class Customer_2steps extends TestBase {
	
	public String f_name;
	public String l_name;
	public String email;
	public String Phone_C;
	public String Country;
	public String City;
	public String ZipCode;
	public String Street;
	public String Job_Title;
	public String Dept;
	public String Company;
	public String Industry;
	public String budget;
	public String Details;
	
	
	public Customer_2steps(String f_name,String l_name,String email,
			String Country,String City,String ZipCode,String Street,String Job_Title,String Dept,
			String Company,String Industry,String Phone_C,String budget,String Details ){
		
		this.f_name=f_name;
		this.l_name=l_name;
		this.email=email;
		this.Country=Country;
		this.City=City;
		this.ZipCode=ZipCode;
		this.Street=Street;
		this.Job_Title=Job_Title;
		this.Dept=Dept;
		this.Company=Company;
		this.Industry=Industry;
		this.Phone_C=Phone_C;
		this.budget=budget;
		this.Details=Details;
		
	}
	@Before
	public void beforeTest() throws IOException{
		System.out.println("Opening the Browser");
		initialize();

		// xlsx file
		if(TestUtil.isSkip("Customer"))
			Assume.assumeTrue(false);
	}
	
	
	
	@Test
	public void regCustomer2Steps(){
		
		driver.get(CONFIG.getProperty("Firewallaccess"));
		driver.get(CONFIG.getProperty("DeleteUser"));
		driver.get(CONFIG.getProperty("CaptchaCheat"));
		driver.get(CONFIG.getProperty("testSiteName"));
		
		getObject("Join_Now").click();
		getObject("Customer").click();
	    getObject("First_Name").sendKeys(f_name);
	    getObject("Last_Name").sendKeys(l_name);
	    getObject("Email").sendKeys(email);
	 
	    Select X= new Select(getObject("Country"));
	    X.selectByVisibleText(Country);
	    getObject("City").clear();
	    getObject("City").sendKeys(City);
	    getObject("city_link").click();
	    getObject("Zip_Code").sendKeys(ZipCode);
	    getObject("Street").sendKeys(Street);
	    getObject("Job_Title").sendKeys(Job_Title);
	    getObject("Dept").sendKeys(Dept);
	    getObject("Company").sendKeys(Company);
	    Select Y= new Select(getObject("Industry"));
	    Y.selectByVisibleText(Industry);
	    getObject("Phone_C").sendKeys(Phone_C);
	    getObject("Next").click();
	    getObject("Project_Start").click();
	    getObject("Calender1").click();
	    getObject("Project_Deadline").click();
	    getObject("Calender2").click();
	    getObject("budget").sendKeys(budget);
	    getObject("Details").sendKeys(Details);
	    getObject("Register_Now_Customer_2ndPage").click();
        
	    
	    try{
	    	assertEquals("Thank you",driver.findElement(By.xpath("html/body/div[1]/div[3]/div/div/h3")).getText());
			assertEquals("for registering as a passbrains Customer!",driver.findElement(By.xpath("html/body/div[1]/div[3]/div/div/h4")).getText());
			assertEquals("An email notification is sent to your inbox to activate your account.",driver.findElement(By.xpath("html/body/div[1]/div[3]/div/div/p")).getText()); 
	    	
			}catch(Throwable t){
				TestUtil.takeScreenShot("regerror_Customer");
					System.err.println("error in registration");
				}
			
	    
	    
	}
	
	@After
	public void teardown() throws IOException{
		System.out.println("Closing the Browser");
		closebrowser();
	}
	
	@Parameters
	public static Collection<Object[]> dataSupplier(){
		System.out.println("Collecting data");
		// read data fromthkYou xls file and write in into Object array.
		Object[][] data = TestUtil.getData("Customer_2steps");
		
		return Arrays.asList(data);

		
		
	}
	
}