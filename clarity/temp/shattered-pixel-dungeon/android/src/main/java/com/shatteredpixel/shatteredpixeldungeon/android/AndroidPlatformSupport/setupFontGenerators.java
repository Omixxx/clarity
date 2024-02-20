class Snippet {
     public void setupFontGenerators(int pageSize, boolean systemfont){
         //don't bother doing anything if nothing has changed
         if (fonts != null && this.pageSize == pageSize && this.systemfont == systemfont) {
             return;
         }
         this.pageSize = pageSize;
         this.systemfont = systemfont;
         resetGenerators(false);
         fonts = new HashMap<>();
         basicFontGenerator = KRFontGenerator = SCFontGenerator = JPFontGenerator = null;
         if (systemfont && Gdx.files.absolute("/system/fonts/Roboto-Regular.ttf").exists()) {
             basicFontGenerator = new FreeTypeFontGenerator(Gdx.files.absolute("/system/fonts/Roboto-Regular.ttf"));
         } else if (systemfont && Gdx.files.absolute("/system/fonts/DroidSans.ttf").exists()) {
             basicFontGenerator = new FreeTypeFontGenerator(Gdx.files.absolute("/system/fonts/DroidSans.ttf"));
         } else {
             basicFontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/pixel_font.ttf"));
         }
         //android 7.0+. all asian fonts are nicely contained in one spot
         if (Gdx.files.absolute("/system/fonts/NotoSansCJK-Regular.ttc").exists()) {
             //typefaces are 0-JP, 1-KR, 2-SC, 3-TC.
             int typeFace;
             switch(SPDSettings.language()) {
                 case JAPANESE:
                     typeFace = 0;
                     break;
                 case KOREAN:
                     typeFace = 1;
                     break;
                 case CHINESE:
                 default:
                     typeFace = 2;
             }
             KRFontGenerator = SCFontGenerator = JPFontGenerator = new FreeTypeFontGenerator(Gdx.files.absolute("/system/fonts/NotoSansCJK-Regular.ttc"), typeFace);
             //otherwise we have to go over a few possibilities.
         } else {
             //Korean font generators
             if (Gdx.files.absolute("/system/fonts/NanumGothic.ttf").exists()) {
                 KRFontGenerator = new FreeTypeFontGenerator(Gdx.files.absolute("/system/fonts/NanumGothic.ttf"));
             } else if (Gdx.files.absolute("/system/fonts/NotoSansKR-Regular.otf").exists()) {
                 KRFontGenerator = new FreeTypeFontGenerator(Gdx.files.absolute("/system/fonts/NotoSansKR-Regular.otf"));
                 koreanAndroid6OTF = true;
             }
             //Chinese font generators
             if (Gdx.files.absolute("/system/fonts/NotoSansSC-Regular.otf").exists()) {
                 SCFontGenerator = new FreeTypeFontGenerator(Gdx.files.absolute("/system/fonts/NotoSansSC-Regular.otf"));
             } else if (Gdx.files.absolute("/system/fonts/NotoSansHans-Regular.otf").exists()) {
                 SCFontGenerator = new FreeTypeFontGenerator(Gdx.files.absolute("/system/fonts/NotoSansHans-Regular.otf"));
             }
             //Japaneses font generators
             if (Gdx.files.absolute("/system/fonts/NotoSansJP-Regular.otf").exists()) {
                 JPFontGenerator = new FreeTypeFontGenerator(Gdx.files.absolute("/system/fonts/NotoSansJP-Regular.otf"));
             }
             //set up a fallback generator for any remaining fonts
             FreeTypeFontGenerator fallbackGenerator;
             if (Gdx.files.absolute("/system/fonts/DroidSansFallback.ttf").exists()) {
                 fallbackGenerator = new FreeTypeFontGenerator(Gdx.files.absolute("/system/fonts/DroidSansFallback.ttf"));
             } else {
                 //no fallback font, just set to null =/
                 fallbackGenerator = null;
             }
             if (KRFontGenerator == null)
                 KRFontGenerator = fallbackGenerator;
             if (SCFontGenerator == null)
                 SCFontGenerator = fallbackGenerator;
             if (JPFontGenerator == null)
                 JPFontGenerator = fallbackGenerator;
         }
         if (basicFontGenerator != null)
             fonts.put(basicFontGenerator, new HashMap<>());
         if (KRFontGenerator != null)
             fonts.put(KRFontGenerator, new HashMap<>());
         if (SCFontGenerator != null)
             fonts.put(SCFontGenerator, new HashMap<>());
         if (JPFontGenerator != null)
             fonts.put(JPFontGenerator, new HashMap<>());
         //would be nice to use RGBA4444 to save memory, but this causes problems on some gpus =S
         packer = new PixmapPacker(pageSize, pageSize, Pixmap.Format.RGBA8888, 1, false);
     }
}