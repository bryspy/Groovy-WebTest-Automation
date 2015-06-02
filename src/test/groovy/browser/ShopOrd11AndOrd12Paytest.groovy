package hello
import groovy.sql.Sql
import org.junit.AfterClass
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.BlockJUnit4ClassRunner
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver

@RunWith(BlockJUnit4ClassRunner.class)
class ShopOrd11AndOrd12Paytest  extends GroovyTestCase {

	private WebDriver driver



	@Before
	public void createDriver() {
	  // driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome())
		driver = new FirefoxDriver()
	}

	@After
	public void quitDriver() {
	  if (driver != null) {
			driver.quit()
		}

	}


	@Test void paytestHome() {
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
