class Snippet {
   protected FreeTypeFontGenerator getGeneratorForString(String input){
       if (KRMatcher.reset(input).find()) {
           return KRFontGenerator;
       } else if (SCMatcher.reset(input).find()) {
           return SCFontGenerator;
       } else if (JPMatcher.reset(input).find()) {
           return JPFontGenerator;
       } else {
           return basicFontGenerator;
       }
   }

}