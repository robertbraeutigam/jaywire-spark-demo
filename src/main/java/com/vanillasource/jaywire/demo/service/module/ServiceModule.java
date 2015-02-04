package com.vanillasource.jaywire.demo.service.module;

import com.vanillasource.jaywire.demo.service.database.JdbcDatabase;
import com.vanillasource.jaywire.demo.service.content.DatabaseContentService;
import com.vanillasource.jaywire.demo.service.user.DatabaseUserService;
import java.util.function.Supplier;
import com.vanillasource.jaywire.Scope;
import com.vanillasource.jaywire.SingletonScopeSupport;

public abstract class ServiceModule implements SingletonScopeSupport {
   public JdbcDatabase newJdbcDatabase() {
      System.out.println("Instantiating new database...");
      return new JdbcDatabase();
   }

   public JdbcDatabase getJdbcDatabase() {
      return singleton(this::newJdbcDatabase);
   }

   public DatabaseContentService getDatabaseContentService() {
      return singleton(() -> new DatabaseContentService(getJdbcDatabase()));
   }

   public DatabaseUserService getDatabaseUserService() {
      return singleton(() -> new DatabaseUserService(getJdbcDatabase()));
   }
}
