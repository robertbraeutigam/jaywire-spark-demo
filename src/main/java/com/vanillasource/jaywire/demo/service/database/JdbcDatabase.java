package com.vanillasource.jaywire.demo.service.database;

import javax.sql.DataSource;

public class JdbcDatabase implements Database {
   @Override
   public DataSource getDataSource() {
      return null; // Create/Get datasource
   }

   @Override
   public void close() {
      // Close datasource
   }
}
