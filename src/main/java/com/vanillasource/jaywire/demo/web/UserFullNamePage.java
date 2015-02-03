package com.vanillasource.jaywire.demo.web;

import com.vanillasource.jaywire.demo.service.user.UserService;
import spark.Route;
import spark.Request;
import spark.Response;

public class UserFullNamePage implements Route {
   private UserService userService;

   public UserFullNamePage(UserService userService) {
      this.userService = userService;
   }

   @Override
   public String handle(Request request, Response response) {
      return "The john's full name is: "+userService.getFullName("john");
   }
}

