package com.vanillasource.jaywire.demo.service.module;

import com.vanillasource.jaywire.demo.service.database.*;
import com.vanillasource.jaywire.demo.service.content.*;
import com.vanillasource.jaywire.demo.service.user.*;

import com.vanillasource.jaywire.SingletonScopeSupport;
import com.vanillasource.jaywire.Scope;
import com.vanillasource.jaywire.SessionScopeSupport;
import java.util.function.Supplier;

public interface ServiceModule extends SingletonScopeSupport, SessionScopeSupport {
   default Database getDatabase() {
      return singleton( () -> new JdbcDatabase() );
   }

   default ContentService getContentService() {
      return singleton( () -> new DatabaseContentService(getDatabase()) );
   }

   default Supplier<UserService> getUserService() {
      return getSessionScope().apply(() -> new DatabaseUserService(getDatabase()));
   }
}


