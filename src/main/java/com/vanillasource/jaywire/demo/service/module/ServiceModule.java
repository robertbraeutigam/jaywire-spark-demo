package com.vanillasource.jaywire.demo.service.module;

import com.vanillasource.jaywire.demo.service.database.*;
import com.vanillasource.jaywire.demo.service.content.*;
import com.vanillasource.jaywire.demo.service.user.*;

public class ServiceModule {
   public Database getDatabase() {
      return new JdbcDatabase();
   }

   public ContentService getContentService() {
      return new DatabaseContentService(getDatabase());
   }

   public UserService getUserService() {
      return new DatabaseUserService(getDatabase());
   }
}


