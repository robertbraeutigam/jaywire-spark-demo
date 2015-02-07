package com.vanillasource.jaywire.demo.service.user;

public interface UserService {
   boolean login(String userName, String password);

   String getUserName();
}

