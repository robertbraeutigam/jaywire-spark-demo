package com.vanillasource.jaywire.demo.service.module;

import com.vanillasource.jaywire.demo.service.database.*;
import com.vanillasource.jaywire.demo.service.content.*;
import com.vanillasource.jaywire.demo.service.user.*;
import java.util.function.Supplier;

public abstract class ServiceModule {
   public Database getDatabase() {
      return singleton( () -> new JdbcDatabase() );
   }

   public ContentService getContentService() {
      return singleton( () -> new DatabaseContentService(getDatabase()) );
   }

   private <T> T singleton(Supplier<T> factory) {
      return getSingletonStorage().get(factory);
   }

   public abstract SingletonStorage getSingletonStorage();

   public interface SingletonStorage {
      <T> T get(Supplier<T> factory);
   }

   public UserService getUserService() {
      return new DatabaseUserService(getDatabase());
   }
}


