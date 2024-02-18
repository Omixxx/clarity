class Snippet {
        private static void bundleToStream(OutputStream output, Bundle bundle) throws IOException{
            Bundle.write(bundle, output);
            output.close();
        }

}