package selenium.Testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import seleniumauto.pageobjects.LandingPage;

public class BaseTest {
	
	public WebDriver driver;
   public 	LandingPage lpage;

	public WebDriver intializeDriver() throws IOException {

	    Properties prop = new Properties();
	    FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\seleniumauto\\resources\\GlobalData.properties");
	    
	    prop.load(fis);
	    String browserName = prop.getProperty("browser");
	    
	    if (browserName == null) {
	        throw new IllegalArgumentException("Browser name is not specified in the properties file.");
	    }
	    
	    if (browserName.equalsIgnoreCase("chrome")) {
	        WebDriverManager.chromedriver().setup();
	     driver = new ChromeDriver();
	    }

	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    driver.manage().window().maximize();
	    return driver;
	}
	
	
	public List <HashMap<String ,String>> getJsonDataToMap(String filePath) throws IOException 
	{
		
	String jsonContent = 	FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
	
	
	
	ObjectMapper mapper  = new ObjectMapper();
	List <HashMap<String ,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String ,String>>>(){
			
	});
	
	return data;
	
	}
	public String  getScreenshot (String testCaseName , WebDriver driver) throws IOException 
	{
       TakesScreenshot ts =  (TakesScreenshot)driver;
      File source = ts.getScreenshotAs(OutputType.FILE);
      File file = new File(System.getProperty("user.dir")+"//reports"+testCaseName+".png") ;
      FileUtils.copyFile(source, file);
       return System.getProperty("user.dir")+"//reports"+testCaseName+".png";
	}
	
	
	
     
    @BeforeMethod(alwaysRun = true)
	public LandingPage launchapplication() throws IOException {
		
	  driver  =	 intializeDriver();
		lpage = new LandingPage(driver);
		lpage.WebPage();
		return lpage;
	  
	}
    
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
    	driver.close();
    }
    
	
	
}
