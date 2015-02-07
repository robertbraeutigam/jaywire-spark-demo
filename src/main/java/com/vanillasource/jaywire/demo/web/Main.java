package com.vanillasource.jaywire.demo.web;

import static spark.Spark.*;
import spark.Request;
import spark.Response;

public class Main {
   public static final void main(String[] args) {
      get("/", Main::getHomePage);
      AppModule app = new AppModule();
      get("/content", app.newContentPage());
      get("/username", app.newUserNamePage());
      post("/username", app.newSetUserNamePage());
   }

   private static final String getHomePage(Request request, Response response) {
      return 
         "<html>"+
         "   <head><title>JayWire Demo</title></head>"+
         "   <body>"+
         "      <h1>Demo Home Page</h1>"+
         "      <h5>Please choose page from list below</h5>"+
         "      <ul>"+
         "         <li><a href=\"/content\">Content Page</a></li>"+
         "         <li><a href=\"/username\">User Full Name Page</a></li>"+
         "         <li>Set username: <form action=\"/username\" method=\"post\"><input name=\"username\"></input></form></li>"+
         "      </ul>"+
         "   </body>"+
         "</html>";
   }
}
