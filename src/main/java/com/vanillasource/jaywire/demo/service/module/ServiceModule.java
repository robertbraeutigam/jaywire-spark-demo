package com.vanillasource.jaywire.demo.service.module;

import com.vanillasource.jaywire.demo.service.database.*;
import com.vanillasource.jaywire.demo.service.content.*;
import com.vanillasource.jaywire.demo.service.user.*;

import com.vanillasource.jaywire.SingletonScopeSupport;
import com.vanillasource.jaywire.Scope;
import com.vanillasource.jaywire.SessionScopeSupport;
import java.util.function.Supplier;

public abstract class ServiceModule implements SingletonScopeSupport, SessionScopeSupport {
   public Database getDatabase() {
      return singleton( () -> new JdbcDatabase() );
   }

   public ContentService getContentService() {
      return singleton( () -> new DatabaseContentService(getDatabase()) );
   }

   public Supplier<UserService> getUserService() {
      return getSessionScope().apply(() -> new DatabaseUserService(getDatabase()));
   }
}


