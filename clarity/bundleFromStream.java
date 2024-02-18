class Snippet {
      private static Bundle bundleFromStream(InputStream input) throws IOException{
          Bundle bundle = Bundle.read(input);
          input.close();
          return bundle;
      }

}