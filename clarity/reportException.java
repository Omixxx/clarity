class Snippet {
    public static void reportException(Throwable tr){
        if (instance != null && Gdx.app != null) {
            instance.logException(tr);
        } else {
            //fallback if error happened in initialization
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            tr.printStackTrace(pw);
            pw.flush();
            System.err.println(sw.toString());
        }
    }

}