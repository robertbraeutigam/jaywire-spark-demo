package com.vanillasource.jaywire.demo.web;

import com.vanillasource.jaywire.demo.service.user.UserService;
import spark.Route;
import spark.Request;
import spark.Response;
import java.util.function.Supplier;

public class UserNamePage implements Route {
   private Supplier<? extends UserService> userService;

   public UserNamePage(Supplier<? extends UserService> userService) {
      this.userService = userService;
   }

   @Override
   public String handle(Request request, Response response) {
      return "Your username is: "+userService.get().getUserName();
   }
}

