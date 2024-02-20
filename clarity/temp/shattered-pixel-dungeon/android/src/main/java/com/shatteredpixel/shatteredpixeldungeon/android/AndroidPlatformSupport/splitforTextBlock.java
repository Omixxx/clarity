class Snippet {
     public String[] splitforTextBlock(String text, boolean multiline){
         if (koreanAndroid6OTF && getGeneratorForString(text) == KRFontGenerator) {
             return android6KRSplitter.split(text);
         } else if (multiline) {
             return regularsplitterMultiline.split(text);
         } else {
             return regularsplitter.split(text);
         }
     }
}