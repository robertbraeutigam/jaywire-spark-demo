package com.vanillasource.jaywire.demo.service.module;

import com.vanillasource.jaywire.demo.service.database.JdbcDatabase;
import com.vanillasource.jaywire.demo.service.content.DatabaseContentService;
import com.vanillasource.jaywire.demo.service.user.DatabaseUserService;

public abstract class ServiceModule {
   public JdbcDatabase newJdbcDatabase() {
      return new JdbcDatabase();
   }

   public abstract Scope getSingletonScope();

   public interface Scope {
      <T> T apply(Factory<T> value);
   }

   public interface Factory<T> {
      T get();
   }

   private Factory<JdbcDatabase> jdbcDatabaseFactory = new Factory<JdbcDatabase>() {
      @Override
      public JdbcDatabase get() {
         return newJdbcDatabase();
      }
   };

   public JdbcDatabase getJdbcDatabase() {
      return getSingletonScope().apply(jdbcDatabaseFactory);
   }

   public DatabaseContentService newDatabaseContentService() {
      return new DatabaseContentService(newJdbcDatabase());
   }

   public DatabaseUserService newDatabaseUserService() {
      return new DatabaseUserService(newJdbcDatabase());
   }
}
