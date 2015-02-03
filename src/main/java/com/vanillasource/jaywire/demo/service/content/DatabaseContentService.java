package com.vanillasource.jaywire.demo.service.content;

import com.vanillasource.jaywire.demo.service.database.Database;

public class DatabaseContentService implements ContentService {
   private Database database;

   public DatabaseContentService(Database database) {
      this.database = database;
   }

   @Override
   public String getPageContent(String pageName) {
      return "Content"; // Get from the database
   }
}

