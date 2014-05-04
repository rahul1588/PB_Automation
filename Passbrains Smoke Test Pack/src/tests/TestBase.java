package tests;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import util.TestUtil;
import datatable.Xls_Reader;

public class TestBase {
	
	// initalizing the property file reading
	public static Properties CONFIG=null;
	public static Properties OR=null;
	public static WebDriver dr=null;
	public static EventFiringWebDriver driver=null;
	public static boolean isLoggedIn=false;
	public static Xls_Reader datatable=null;
	
	public void initialize() throws IOException{
	if(driver == null){
		// config property file
		CONFIG= new Properties();
		FileInputStream fn =new FileInputStream(System.getProperty("user.dir")+"//src//grid/config.properties");
		CONFIG.load(fn);
		// OR Properties
		OR= new Properties();
		fn =new FileInputStream(System.getProperty("user.dir")+"//src//grid/OR.properties");
		OR.load(fn);
		// Initalize the webdriver and EventFiringWebDriver
		if(CONFIG.getProperty("browser").equals("Firefox")){
			 dr = new FirefoxDriver();
		}else if(CONFIG.getProperty("browser").equals("IE")){
			 System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"//src/executables/IEDriverServer.exe");
			 dr = new InternetExplorerDriver();
		}
		else if(CONFIG.getProperty("browser").equals("Chrome")){
			 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src/executables/chromedriver.exe");
			 dr = new ChromeDriver();
		}
		
		 driver = new EventFiringWebDriver(dr);
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 
	}
	}

  
	public static WebElement getObject(String xpathKey) {
		try{
			return driver.findElement(By.xpath(OR.getProperty(xpathKey)));
		}catch(Throwable t){
			// report error
			TestUtil.takeScreenShot(xpathKey);
			Assert.assertTrue(t.getMessage(),false);
			
			return null;
		}
		
	}
}