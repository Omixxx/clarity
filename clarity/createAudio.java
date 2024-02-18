class Snippet {
     public AndroidAudio createAudio(Context context, AndroidApplicationConfiguration config){
         return new AsynchronousAndroidAudio(context, config);
     }

}