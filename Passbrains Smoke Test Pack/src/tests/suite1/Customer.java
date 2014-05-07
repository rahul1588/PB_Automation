package tests.suite1;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;


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
public class Customer extends TestBase {
	
	public String f_name;
	public String l_name;
	public String email;
	public String Phone;
	public String Country;
	public String City;
	public String ZipCode;
	public String Street;
	public String Job_Title;
	public String Dept;
	public String Company;
	public String Industry;
	//public String DOB;
	//public String hours;
	
	public Customer(String f_name,String l_name,String email,
			String Country,String City,String ZipCode,String Street,String Job_Title,String Dept,
			String Company,String Industry,String Phone ){
		
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
		this.Phone=Phone;
		//this.DOB=DOB;
		//this.hours=hours;
	}
	@Before
	public void beforeTest() throws IOException{
		System.out.println("Initializing the system");
		initialize();

		// xlsx file
		if(TestUtil.isSkip("Customer"))
			Assume.assumeTrue(false);
	}
	
	
	
	@Test
	public void regCustomer(){
		
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
	    getObject("Industry").sendKeys(Industry);
	    getObject("Phone").sendKeys(Phone);
	    /*getObject("Gender_Male").click();
	    getObject("DOB").sendKeys(DOB);
        getObject("num_hours").sendKeys(hours);
	    getObject("Terms").click();
	    getObject("Register_Now").click();*/
        
	    
	    try{
	    	assertEquals("Thank you",driver.findElement(By.xpath("Thank_msg")).getText());
			assertEquals("for registering as a passbrains Customer!",driver.findElement(By.xpath("confirmation_novice")).getText());
			assertEquals("An email notification is sent to your inbox to activate your account.",driver.findElement(By.xpath("email_notification")).getText()); 
	    	
			}catch(Throwable t){
				TestUtil.takeScreenShot("regerror_Customer");
					System.err.println("error in registration");
				}
			
	    
	    
	}
	
	@Parameters
	public static Collection<Object[]> dataSupplier(){
		System.out.println("Collecting data");
		// read data fromthkYou xls file and write in into Object array.
		Object[][] data = TestUtil.getData("Customer");
		
		return Arrays.asList(data);

		
		
	}
	
	
}
