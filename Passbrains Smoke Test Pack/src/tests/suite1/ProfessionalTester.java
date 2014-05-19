package tests.suite1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import tests.TestBase;
import util.TestUtil;

@RunWith(Parameterized.class)
public class ProfessionalTester extends TestBase{

	public String f_name;
	public String l_name;
	public String email;
	public String Phone;
	public String SkypeID;
	public String PayPal;
	public String Country;
	public String City;
	public String ZipCode;
	public String Street;	
	public String DOB;
	public String Experience;
	public String hours;
	
	
	public ProfessionalTester(String f_name,String l_name,String email,String Phone,String SkypeID,
			String PayPal,String Country,String City,String ZipCode,String Street,String DOB,String Experience,
			String hours){
		
		this.f_name=f_name;
		this.l_name=l_name;
		this.email=email;
		this.Phone=Phone;
		this.SkypeID=SkypeID;
		this.PayPal=PayPal;
		this.Country=Country;
		this.City=City;
		this.ZipCode=ZipCode;
		this.Street=Street;
		this.DOB=DOB;
		this.Experience=Experience;
		this.hours=hours;
		
	}
	
	@Before
	public void beforeTest() throws IOException{
		System.out.println("Opening the Browser");
		initialize();

		// xlsx file
		if(TestUtil.isSkip("ProfessionalTester"))
			Assume.assumeTrue(false);
	}
	
	@Test
	public void regProfessional(){
		
		driver.get(CONFIG.getProperty("Firewallaccess"));
		driver.get(CONFIG.getProperty("DeleteUser"));
		driver.get(CONFIG.getProperty("CaptchaCheat"));
		driver.get(CONFIG.getProperty("testSiteName"));
		
		getObject("Join_Now").click();
		getObject("Join_Tester").click();
	    getObject("First_Name").sendKeys(f_name);
	    getObject("Last_Name").sendKeys(l_name);
	    getObject("Email").sendKeys(email);
	    getObject("Phone").sendKeys(Phone);
	    getObject("Skype_ID").sendKeys(SkypeID);
	    getObject("PayPal_Account").sendKeys(PayPal);
	    Select X= new Select(getObject("Country"));
	    X.selectByVisibleText(Country);
	    getObject("City").clear();
	    getObject("City").sendKeys(City);
	    getObject("city_link").click();
	    getObject("Zip_Code").sendKeys(ZipCode);
	    getObject("Street").sendKeys(Street);
	    getObject("Gender_Male").click();
        getObject("DOB").sendKeys(DOB);
        getObject("experience").sendKeys(Experience);
        getObject("num_hours").sendKeys(hours);
	    getObject("Terms").click();
	    getObject("Register_Now").click();
        
	    
	    try{
	    	
	    	assertEquals("Thank you",driver.findElement(By.xpath("html/body/div[1]/div[3]/div/div/h3")).getText());
			assertEquals("for registering as a passbrains Test Expert!",driver.findElement(By.xpath("html/body/div[1]/div[3]/div/div/h4")).getText());
			assertEquals("An email notification is sent to your inbox to activate your account.",driver.findElement(By.xpath("html/body/div[1]/div[3]/div/div/p")).getText()); 
	    	
			}catch(Throwable t){
				TestUtil.takeScreenShot("regerror_Professional");
				System.err.println("error in registration");
					assertTrue("Not Able to Register Professional Tester with correct Data ", false);
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
		
		// read data from xls file and write in into Object array.
		Object[][] data = TestUtil.getData("ProfessionalTester");
		
		return Arrays.asList(data);

		
		
	}
	
	
}
