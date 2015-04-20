package com.vanillasource.jaywire.demo.service.module;

import com.vanillasource.jaywire.demo.service.database.*;
import com.vanillasource.jaywire.demo.service.content.*;
import com.vanillasource.jaywire.demo.service.user.*;

public abstract class ServiceModule implements SingletonSupport {
   public Database getDatabase() {
      return singleton( () -> new JdbcDatabase() );
   }

   public ContentService getContentService() {
      return singleton( () -> new DatabaseContentService(getDatabase()) );
   }

   public UserService getUserService() {
      return new DatabaseUserService(getDatabase());
   }
}


