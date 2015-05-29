package hello
import groovy.sql.*
import org.junit.AfterClass
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.BlockJUnit4ClassRunner
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver

@RunWith(BlockJUnit4ClassRunner.class)
class HelloTest  extends GroovyTestCase {

	/*private static ChromeDriverService service*/

	private WebDriver driver
	Properties properties = new Properties();
	def File propFile = new File('src/test/resources/sut.properties').withInputStream {properties.load(it)};

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

	@After
	public void quitDriver() {
	  driver.quit()
	}


	/*@Test void testHello() {
		//driver.get("http://localhost:8080/zk/hello#world")
		//WebElement label = driver.findElement(By.name("zk_comp_2"))
		//assertEquals "Hello World via Tag", label.text
		def shopperDomainOrdSys12 = "http://gc2-sys-shopper-s2.wipint.digitalriverws.net"
		def shopperDomainOrdSys11 = "http://http://drhshopper-sys-drx.drextenv.net"
		def siteId = "paytest"
//		print 'hello'
//		driver.get("${shopperDomainOrdSys12}/store/${siteId}/home")
	}*/

	@Test void testDB() {

		def sql = Sql.newInstance("${properties.ordsys12JDBC}", "oracle.jdbc.driver.OracleDriver")

	}

}
