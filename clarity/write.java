class Snippet {
        public static boolean write(Bundle bundle, OutputStream stream, boolean compressed){
            try {
                BufferedWriter writer;
                if (compressed)
                    writer = new BufferedWriter(new OutputStreamWriter(new GZIPOutputStream(stream, GZIP_BUFFER)));
                else
                    writer = new BufferedWriter(new OutputStreamWriter(stream));
                //JSONObject.write does not exist on Android/iOS
                writer.write(bundle.data.toString());
                writer.close();
                return true;
            } catch (IOException e) {
                Game.reportException(e);
                return false;
            }
        }

}