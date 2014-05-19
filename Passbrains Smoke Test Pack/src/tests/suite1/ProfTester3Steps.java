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
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import tests.TestBase;
import util.TestUtil;

@RunWith(Parameterized.class)
public class ProfTester3Steps extends TestBase {

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
	public String OS;
	public String version;
	public String language;
	public String manufacturer;
	public String model;
	public String model_OS;
	public String carrier;
	
	
	public ProfTester3Steps(String f_name,String l_name,String email,String Phone,String SkypeID,
			String PayPal,String Country,String City,String ZipCode,String Street,String DOB,
			String hours,String OS,String version,String language,String manufacturer, String model,
			String model_OS,String carrier,String Experience){
		
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
		System.out.println("Opening the Browser");
		initialize();

		// xlsx file
		if(TestUtil.isSkip("ProfessionalTester"))
			Assume.assumeTrue(false);
	}
	
	@Test
	public void Proftester3steps() {
		
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
	    getObject("Next").click();
	    
	    
	    //Adding Experience Details in the Second Page
	    getObject("Domain_accounting").click();
	    getObject("Domain_Banking").click();
	    getObject("Domain_Defence").click();
	    
	    getObject("Expand_Function").click();
	    getObject("Function_Expert").click();
	    getObject("Function_Intermediate").click();
	    getObject("Function_Novice").click();
	    
	    getObject("Expand_TestingType").click();
	    getObject("Testing_Expert").click();
	    getObject("Testing_Intermediate").click();
	    getObject("Testing_Novice").click();
	    
	    getObject("Expand_Automation_Tools").click();
	    getObject("Automation_Expert").click();
	    getObject("Automation_Intermediate").click();
	    getObject("Automation_Novice").click();
	    
	    getObject("Expand_Load_Tools").click();
	    getObject("load_Expert").click();
	    getObject("load_Intermediate").click();
	    getObject("load_Novice").click();
	    
	    getObject("Expand_Certification").click();
	    getObject("Certification_CSTE").click();
	    getObject("Certification_ISTQB_Advance").click();
	    getObject("Certification_ISTQB_Expert").click();
	    
	    getObject("Expand_Languages").click();
	    getObject("English_Expert").click();
	    getObject("Hindi_Intermediate").click();
	    getObject("Russian_Novice").click();
	    
	    getObject("Next_Step2").click();
	    
	    
	    //Adding Configuration details in the 3rd Page
	    try {
			Thread.sleep(5000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    getObject("OS").click();
	    getObject("OS").sendKeys(OS);
	    getObject("OS").sendKeys(Keys.TAB);
	    try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    getObject("OS_Version").sendKeys(version);
	    getObject("OS_Version").sendKeys(Keys.TAB);
	    getObject("OS_Language").sendKeys(language);
	    getObject("Chrome").click();
	    getObject("FF").click();
	    getObject("IE_10").click();
	    getObject("Add_DesktopPC").click();
	    
	    getObject("Manufacturer").click();
	    try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    getObject("Manufacturer").sendKeys(manufacturer);
	    getObject("Manufacturer").sendKeys(Keys.TAB);
	    try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    getObject("Model").click();
	    getObject("Model").sendKeys(model);
	    getObject("Model").sendKeys(Keys.TAB);
	    getObject("Mobile_OS").click();
	    try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    getObject("Mobile_OS").sendKeys(model_OS);
	    getObject("Mobile_OS").sendKeys(Keys.TAB);
	    getObject("Carrier").sendKeys(carrier);

	    getObject("Add_Mobile_Device").click();
	    getObject("Register_Now_2Page").click();
	    
	    
   try{
	    	
	    	assertEquals("Thank you",driver.findElement(By.xpath("html/body/div[1]/div[3]/div/div/h3")).getText());
			assertEquals("for registering as a passbrains Professional Tester!",driver.findElement(By.xpath("html/body/div[1]/div[3]/div/div/h4")).getText());
			assertEquals("An email notification is sent to your inbox to activate your account.",driver.findElement(By.xpath("html/body/div[1]/div[3]/div/div/p")).getText()); 
	    	
			}catch(Throwable t){
				TestUtil.takeScreenShot("regerror_novice");
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
			Object[][] data = TestUtil.getData("ProfTester3Steps");
			
			return Arrays.asList(data);
	    
	    
	}
	
	
	
}
