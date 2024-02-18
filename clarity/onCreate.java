class Snippet {
   protected void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
       TextView text = new TextView(this);
       text.setText("Shattered Pixel Dungeon cannot start because some of its code is missing!\n\n" + "This usually happens when the Google Play version of the game is installed from somewhere outside of Google Play.\n\n" + "If you're unsure of how to fix this, please email the developer (Evan@ShatteredPixel.com), and include this error message:\n\n" + errorMsg);
       text.setTextSize(16);
       text.setTextColor(0xFFFFFFFF);
       text.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/pixel_font.ttf"));
       text.setGravity(Gravity.CENTER_VERTICAL);
       text.setPadding(10, 10, 10, 10);
       setContentView(text);
   }

}