package com.vanillasource.jaywire.demo.service.content;

public class ContentImpl implements Content {
   private String markup;

   public ContentImpl(String markup) {
      this.markup = markup;
   }

   @Override
   public String getHtml() {
      return markup;
   }
}
