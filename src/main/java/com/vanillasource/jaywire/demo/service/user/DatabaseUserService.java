package com.vanillasource.jaywire.demo.service.user;

import com.vanillasource.jaywire.demo.service.database.Database;

public class DatabaseUserService implements UserService {
   private Database database;
   private String userName;

   public DatabaseUserService(Database database) {
      this.database = database;
   }

   @Override
   public boolean login(String userName, String password) {
      this.userName = userName;
      return true;
   }

   @Override
   public String getUserName() {
      return userName;
   }
}
