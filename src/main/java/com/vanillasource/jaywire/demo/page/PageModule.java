package com.vanillasource.jaywire.demo.page;

import com.vanillasource.jaywire.demo.service.module.ServiceModule;

public interface PageModule extends ServiceModule {
   default ContentPage getContentPage() {
      return new ContentPage(getContentService());
   }

   default UserNamePage getUserNamePage() {
      return new UserNamePage(getUserService());
   }

   default SetUserNamePage getSetUserNamePage() {
      return new SetUserNamePage(getUserService());
   }
}

