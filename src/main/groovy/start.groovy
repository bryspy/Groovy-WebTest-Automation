//@Grab(group='org.seleniumhq.selenium', module='selenium-java', version='2.45.0')

import org.openqa.selenium.*
//import org.openqa.selenium.WebDriver
//import org.openqa.selenium.WebElement
import org.junit.runners.BlockJUnit4ClassRunner
import org.junit.runner.RunWith
import org.junit.*
 
@RunWith(BlockJUnit4ClassRunner.class)
class WebDriverTests extends GroovyTestCase {
 
	//private static ChromeDriverService service
	//private WebDriver driver
  
//	@BeforeClass
//	public static void createAndStartService() {
//	  service = new ChromeDriverService.Builder()
//	  	  .usingChromeDriverExecutable(new File('E:/ChromeDriver/chromedriver.exe'))
//		  .usingPort(4444)
//		  .build()
//	  service.start()
//	}
  
	@AfterClass
	public static void createAndStopService() {
	  //service.stop()
	}
  
	@Before
	public void createDriver() {
	  //driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome())
	}
  
	@After
	public void quitDriver() {
	  //driver.quit()
	}
	
	@Test void testSomething() {
		//driver.get("http://localhost:8080/zk/hello#world")
		//WebElement label = driver.findElement(By.name("zk_comp_2"))
		//assertEquals "Hello World via Tag", label.text
		print 'hello'
	}
 
}