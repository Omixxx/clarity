class Snippet {
   protected void logException(Throwable tr){
       StringWriter sw = new StringWriter();
       PrintWriter pw = new PrintWriter(sw);
       tr.printStackTrace(pw);
       pw.flush();
       Gdx.app.error("GAME", sw.toString());
   }

}