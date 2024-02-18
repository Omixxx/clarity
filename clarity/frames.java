class Snippet {
     public Animation frames(TextureFilm film, Object... frames){
         this.frames = new RectF[frames.length];
         for (int i = 0; i < frames.length; i++) {
             this.frames[i] = film.get(frames[i]);
         }
         return this;
     }

}