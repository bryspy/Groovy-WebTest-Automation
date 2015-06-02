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
class RSDB_DataReplicationValidation  extends GroovyTestCase {

	private WebDriver driver
	// Properties properties = new Properties();
	// def File propFile = new File('src/test/resources/sut.properties').withInputStream {properties.load(it)};

	def config = new ConfigSlurper().parse(new File("src/test/resources/sutProperties.groovy").toURL())

	@Test void testDB() {

		config.dbConnections.each { conString ->
			println conString
		}

		println config.dbConnections.ordsys12JDBC

		def ordsys12Con = Sql.newInstance("${config.dbConnections.ordsys12JDBC}", "${config.jdbcDriver}")
		def ord12Rows = ordsys12Con.rows("select * from pmt_payment_information where modification_date > sysdate -1/24")
		println "Found ${ord12Rows.size()} ord12Rows"

		def shrSys11Con = Sql.newInstance("${config.dbConnections.ordsys12JDBC}", "${config.jdbcDriver}")
		def shr11Rows = shrSys11Con.rows("select * from pmt_payment_information where modification_date > sysdate -1/24")
		println "Found ${shr11Rows.size()} shr11Rows"

		def index = 0
		ord12Rows.each {row ->
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
