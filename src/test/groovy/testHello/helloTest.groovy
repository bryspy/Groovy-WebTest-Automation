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


	@AfterClass
	public static void createAndStopService() {
	  //service.stop()
	}

	@Before
	public void createDriver() {
	  //driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome())
		// driver = new FirefoxDriver()
	}

	@After
	public void quitDriver() {
	  if (driver != null) {
			driver.quit()
		}

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

		def ordsys12Con = Sql.newInstance("${properties.ordsys12JDBC}", "${properties.jdbcDriver}")
		def ord12Rows = ordsys12Con.rows("select * from pmt_payment_information where modification_date > sysdate -1/24")
		println "found ${ord12Rows.size()} ord12Rows"

//		ord12Rows.each {row ->
//			println "row: ${row} \n"
//		}

		def shrSys11Con = Sql.newInstance("${properties.ordsys12JDBC}", "${properties.jdbcDriver}")
		def shr11Rows = shrSys11Con.rows("select * from pmt_payment_information where modification_date > sysdate -1/24")
		println "found ${shr11Rows.size()} ord12Rows"

		def index = 0
		ord12Rows.each {row ->
//			println row
			def shrRow = shr11Rows.get(index)

			row.each {column ->

				if (!column.value.equals(shrRow.getAt(column.key))) {
					println "ord12 ${column.key}: ${column.value} Does not Match shr11 ${shrRow.getAt(column.value)}!!!"
				}
			}
			assert row.equals(shr11Rows.get(index))
			index++
		}


	}

}
