package com.vanillasource.jaywire.demo.page;

import com.vanillasource.jaywire.demo.service.user.UserService;
import spark.Route;
import spark.Request;
import spark.Response;
import java.util.function.Supplier;

public class SetUserNamePage implements Route {
   private Supplier<? extends UserService> userService;

   public SetUserNamePage(Supplier<? extends UserService> userService) {
      this.userService = userService;
   }

   @Override
   public Object handle(Request request, Response response) {
      userService.get().login(request.queryParams("username"), "");
      response.redirect("/username");
      return null;
   }
}

