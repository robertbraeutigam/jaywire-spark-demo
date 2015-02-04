package com.vanillasource.jaywire.demo.service.module;

import com.vanillasource.jaywire.demo.service.database.JdbcDatabase;
import com.vanillasource.jaywire.demo.service.content.DatabaseContentService;
import com.vanillasource.jaywire.demo.service.user.DatabaseUserService;
import java.util.function.Supplier;
import com.vanillasource.jaywire.Scope;
import com.vanillasource.jaywire.SingletonScopeSupport;

public interface ServiceModule extends SingletonScopeSupport {
   default JdbcDatabase newJdbcDatabase() {
      System.out.println("Instantiating new database...");
      return new JdbcDatabase();
   }

   default JdbcDatabase getJdbcDatabase() {
      return singleton(this::newJdbcDatabase);
   }

   default DatabaseContentService getDatabaseContentService() {
      return singleton(() -> new DatabaseContentService(getJdbcDatabase()));
   }

   default DatabaseUserService getDatabaseUserService() {
      return singleton(() -> new DatabaseUserService(getJdbcDatabase()));
   }
}
