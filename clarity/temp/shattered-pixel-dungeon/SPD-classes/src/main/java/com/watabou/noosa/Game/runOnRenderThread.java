class Snippet {
    public static void runOnRenderThread(Callback c){
        Gdx.app.postRunnable(new Runnable() {
    
            @Override
            public void run() {
                c.call();
            }
        });
    }
}