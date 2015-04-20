package com.vanillasource.jaywire.demo.service.module;

import com.vanillasource.jaywire.demo.service.database.*;
import com.vanillasource.jaywire.demo.service.content.*;
import com.vanillasource.jaywire.demo.service.user.*;

public class ServiceModule {
   private Database database = new JdbcDatabase();
   private ContentService contentService = new DatabaseContentService(getDatabase());

   public Database getDatabase() {
      return database;
   }

   public ContentService getContentService() {
      return contentService;
   }

   public UserService getUserService() {
      return new DatabaseUserService(getDatabase());
   }
}


