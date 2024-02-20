class Snippet {
    public static Program create(Shader... shaders){
        Program program = new Program();
        for (int i = 0; i < shaders.length; i++) {
            program.attach(shaders[i]);
        }
        program.link();
        return program;
    }
}