class Snippet {
           public void grid(int left, int top, int width, int height, int cols){
               uvLeft = (float) left / tx.width;
               uvTop = (float) top / tx.height;
               uvWidth = (float) width / tx.width;
               uvHeight = (float) height / tx.height;
               this.cols = cols;
           }

}