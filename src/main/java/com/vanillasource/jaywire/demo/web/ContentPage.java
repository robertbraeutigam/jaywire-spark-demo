package com.vanillasource.jaywire.demo.web;

import com.vanillasource.jaywire.demo.service.content.ContentService;
import spark.Route;
import spark.Request;
import spark.Response;

public class ContentPage implements Route {
   private ContentService contentService;

   public ContentPage(ContentService contentService) {
      this.contentService = contentService;
   }

   @Override
   public String handle(Request request, Response response) {
      return "The content from Page #1 is: "+contentService.getPageContent("page1");
   }
}
