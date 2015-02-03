package com.vanillasource.jaywire.demo.service.module;

import com.vanillasource.jaywire.demo.service.database.JdbcDatabase;
import com.vanillasource.jaywire.demo.service.content.DatabaseContentService;
import com.vanillasource.jaywire.demo.service.user.DatabaseUserService;
import java.util.function.Supplier;
import com.vanillasource.jaywire.Scope;
import com.vanillasource.jaywire.SingletonScopeSupport;

public abstract class ServiceModule implements SingletonScopeSupport {
   public JdbcDatabase newJdbcDatabase() {
      return new JdbcDatabase();
   }

   public JdbcDatabase getJdbcDatabase() {
      return getSingletonScope().get(this::newJdbcDatabase);
   }

   public DatabaseContentService newDatabaseContentService() {
      return new DatabaseContentService(getJdbcDatabase());
   }

   public DatabaseUserService newDatabaseUserService() {
      return new DatabaseUserService(getJdbcDatabase());
   }
}
