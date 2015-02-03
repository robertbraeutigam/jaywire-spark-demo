package com.vanillasource.jaywire.demo.service.user;

import com.vanillasource.jaywire.demo.service.database.Database;

public class DatabaseUserService implements UserService {
   private Database database;

   public DatabaseUserService(Database database) {
      this.database = database;
   }

   @Override
   public String getFullName(String userName) {
      return "Full Name"; //Get from database
   }
}
