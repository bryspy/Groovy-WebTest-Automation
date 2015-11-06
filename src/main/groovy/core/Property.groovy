package core

class Property {

    def config
    String JDBCdriver

    public Property() {
        config = new ConfigSlurper().parse(new File("src/test/resources/sutProperties.groovy").toURL())
        JDBCdriver = config.jdbcDriver
    }
}
