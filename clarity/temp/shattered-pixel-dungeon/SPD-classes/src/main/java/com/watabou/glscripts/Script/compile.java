class Snippet {
   public void compile(String src){
       String[] srcShaders = src.split("//\n");
       attach(Shader.createCompiled(Shader.VERTEX, srcShaders[0]));
       attach(Shader.createCompiled(Shader.FRAGMENT, srcShaders[1]));
       link();
   }
}