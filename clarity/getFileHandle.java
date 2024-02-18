class Snippet {
        public static FileHandle getFileHandle(Files.FileType type, String basePath, String name){
            switch(type) {
                case Classpath:
                    return Gdx.files.classpath(basePath + name);
                case Internal:
                    return Gdx.files.internal(basePath + name);
                case External:
                    return Gdx.files.external(basePath + name);
                case Absolute:
                    return Gdx.files.absolute(basePath + name);
                case Local:
                    return Gdx.files.local(basePath + name);
                default:
                    return null;
            }
        }

}