package com.vanillasource.jaywire.demo.service.module;

import com.vanillasource.jaywire.demo.service.database.JdbcDatabase;
import com.vanillasource.jaywire.demo.service.content.DatabaseContentService;
import com.vanillasource.jaywire.demo.service.user.DatabaseUserService;
import java.util.function.Supplier;

public abstract class ServiceModule {
   public JdbcDatabase newJdbcDatabase() {
      return new JdbcDatabase();
   }

   public abstract Scope getSingletonScope();

   public interface Scope {
      <T> T get(Supplier<T> value);
   }

   public JdbcDatabase getJdbcDatabase() {
      return getSingletonScope().get(this::newJdbcDatabase);
   }

   public DatabaseContentService newDatabaseContentService() {
      return new DatabaseContentService(newJdbcDatabase());
   }

   public DatabaseUserService newDatabaseUserService() {
      return new DatabaseUserService(newJdbcDatabase());
   }
}
