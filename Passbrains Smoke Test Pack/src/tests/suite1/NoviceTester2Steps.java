package tests.suite1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import tests.TestBase;
import util.TestUtil;

@RunWith(Parameterized.class)
public class NoviceTester2Steps extends TestBase {
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
	public String hours;
	public String OS;
	public String version;
	public String language;
	public String manufacturer;
	public String model;
	public String model_OS;
	public String carrier;
	
	
	public NoviceTester2Steps(String f_name,String l_name,String email,String Phone,String SkypeID,
			String PayPal,String Country,String City,String ZipCode,String Street,String DOB,
			String hours,String OS,String version,String language,String manufacturer, String model,
			String model_OS,String carrier){
		
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
		this.hours=hours;
		this.OS=OS;
		this.version=version;
		this.language=language;
		this.manufacturer=manufacturer;
		this.model=model;
		this.model_OS=model_OS;
		this.carrier=carrier;
	}
	@Before
	public void beforeTest() throws IOException{
		System.out.println("Initializing the system");
		initialize();

		// xlsx file
		if(TestUtil.isSkip("NoviceTester2Steps"))
			Assume.assumeTrue(false);
	}
	
	
	
	@Test
	public void regnovice2steps() {
		
		driver.get(CONFIG.getProperty("Firewallaccess"));
		driver.get(CONFIG.getProperty("DeleteUser"));
		driver.get(CONFIG.getProperty("CaptchaCheat"));
		driver.get(CONFIG.getProperty("testSiteName"));
		
		getObject("Join_Now").click();
		getObject("Join_Tester").click();
		getObject("Tester_Novice").click();
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
        getObject("num_hours").sendKeys(hours);
	    getObject("Terms").click();
	    getObject("Next").click();
	    
	    //Adding Configuration details in the Next Page
	    getObject("OS").sendKeys(OS);
	    getObject("OS").sendKeys(Keys.ENTER);
	    try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getObject("OS_Version").click();
	    getObject("OS_Version").sendKeys(version);
	    getObject("OS_Language").sendKeys(language);
	    getObject("Chrome").click();
	    getObject("FF").click();
	    getObject("IE_10").click();
	    getObject("Add_DesktopPC").click();
	    
	    getObject("Manufacturer").sendKeys(manufacturer);
	    getObject("Manufacturer").sendKeys(Keys.ENTER);
	    getObject("Model").click();
	    try {
			Thread.sleep(5000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    getObject("Model").sendKeys(model);
	    getObject("Model").sendKeys(Keys.ENTER);
	    try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    getObject("Mobile_OS").click();
	    getObject("Mobile_OS").sendKeys(model_OS);
	    getObject("Carrier").sendKeys(carrier);

	    
	    
	    getObject("Add_Mobile_Device").click();
	    getObject("Register_Now_2Page").click();
	    
	    
   try{
	    	
	    	assertEquals("Thank you",driver.findElement(By.xpath("html/body/div[1]/div[3]/div/div/h3")).getText());
			assertEquals("for registering as a passbrains Novice Tester!",driver.findElement(By.xpath("html/body/div[1]/div[3]/div/div/h4")).getText());
			assertEquals("An email notification is sent to your inbox to activate your account.",driver.findElement(By.xpath("html/body/div[1]/div[3]/div/div/p")).getText()); 
	    	
			}catch(Throwable t){
				TestUtil.takeScreenShot("regerror_novice");
				System.err.println("error in registration");
					assertTrue("Not Able to Register Novice Tester with correct Data ", false);
				}
	    
	    
	    }
	    
	    
	    @Parameters
		public static Collection<Object[]> dataSupplier(){
			System.out.println("Collecting data");
			
			// read data from xls file and write in into Object array.
			Object[][] data = TestUtil.getData("NoviceTester2Steps");
			
			return Arrays.asList(data);
	    
	    
	}
}
