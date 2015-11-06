package core
import groovy.sql.Sql

class DB {

  public DB() {

  }

  public def queryRows(String query, String dbJDBCconnectionString) {
      def con = Sql.newInstance(dbJDBCconnectionString, Property.getJDBCdriver())
      return con.rows(query)
  }

}
