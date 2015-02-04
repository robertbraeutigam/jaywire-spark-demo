package com.vanillasource.jaywire.demo.web;

import com.vanillasource.jaywire.demo.service.module.ServiceModule;

public interface PageModule extends ServiceModule {
   default ContentPage newContentPage() {
      return new ContentPage(getDatabaseContentService());
   }

   default UserFullNamePage newUserFullNamePage() {
      return new UserFullNamePage(getDatabaseUserService());
   }
}

