class Snippet {
   public static RectF getSafeInsets(){
       RectF result = new RectF();
       result.left = Gdx.graphics.getSafeInsetLeft();
       result.top = Gdx.graphics.getSafeInsetTop();
       result.right = Gdx.graphics.getSafeInsetRight();
       result.bottom = Gdx.graphics.getSafeInsetBottom();
       return result;
   }
}