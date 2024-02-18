class Snippet {
      public static Shader createCompiled(int type, String src){
          Shader shader = new Shader(type);
          shader.source(src);
          shader.compile();
          return shader;
      }

}