package hello

import org.openqa.selenium.*
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.runners.BlockJUnit4ClassRunner
import org.junit.runner.RunWith
import org.junit.*

@RunWith(BlockJUnit4ClassRunner.class)
class HelloTest  extends GroovyTestCase {

	/*private static ChromeDriverService service*/

	private WebDriver driver

	/*@BeforeClass
	public static void createAndStartService() {
	  service = new ChromeDriverService.Builder()
	  	  .usingChromeDriverExecutable(new File('E:/ChromeDriver/chromedriver.exe'))
		  .usingPort(4444)
 		  .build()
	  service.start()
	}*/

	@AfterClass
	public static void createAndStopService() {
	  //service.stop()
	}

	@Before
	public void createDriver() {
	  //driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome())
		driver = new FirefoxDriver()
	}

	/*@After
	public void quitDriver() {
	  driver.quit()
	}*/


	@Test void testHello() {
		//driver.get("http://localhost:8080/zk/hello#world")
		//WebElement label = driver.findElement(By.name("zk_comp_2"))
		//assertEquals "Hello World via Tag", label.text
		def shopperDomainOrdSys12 = "http://gc2-sys-shopper-s2.wipint.digitalriverws.net"
		def shopperDomainOrdSys11 = "http://http://drhshopper-sys-drx.drextenv.net"
		def siteId = "paytest"
		print 'hello'
		driver.get("${shopperDomainOrdSys12}/store/${siteId}/home")
	}

}
