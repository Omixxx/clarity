class Snippet {
      public static Bundle read(InputStream stream) throws IOException{
          try {
              if (!stream.markSupported()) {
                  stream = new BufferedInputStream(stream, 2);
              }
              //determines if we're reading a regular, or compressed file
              stream.mark(2);
              byte[] header = new byte[2];
              stream.read(header);
              stream.reset();
              //GZIP header is 0x1f8b
              if (header[0] == (byte) 0x1f && header[1] == (byte) 0x8b) {
                  stream = new GZIPInputStream(stream, GZIP_BUFFER);
              }
              //JSONTokenizer only has a string-based constructor on Android/iOS
              BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
              StringBuilder jsonBuilder = new StringBuilder();
              String line;
              while ((line = reader.readLine()) != null) {
                  jsonBuilder.append(line);
                  jsonBuilder.append("\n");
              }
              String jsonString = jsonBuilder.toString();
              Object json;
              try {
                  json = new JSONTokener(jsonString).nextValue();
              } catch (Exception e) {
                  //TODO support for v1.1.X saves has been dropped, can probably remove this soon
                  //if the string can't be tokenized, it may be written by v1.1.X, which used libGDX JSON.
                  // Some of these are written in a 'minified' format, some have duplicate keys.
                  // We read them in with the libGDX JSON code, fix duplicates, write as full JSON
                  // and then try to read again with org.json
                  Game.reportException(e);
                  JsonValue gdxJSON = new JsonReader().parse(jsonString);
                  killDuplicateKeysInLibGDXJSON(gdxJSON);
                  json = new JSONTokener(gdxJSON.prettyPrint(JsonWriter.OutputType.json, 0)).nextValue();
              }
              reader.close();
              //if the data is an array, put it in a fresh object with the default key
              if (json instanceof JSONArray) {
                  json = new JSONObject().put(DEFAULT_KEY, json);
              }
              return new Bundle((JSONObject) json);
          } catch (Exception e) {
              Game.reportException(e);
              throw new IOException();
          }
      }
}