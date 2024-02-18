class Snippet {
     public void keyTyped(TextField textField, char c){
         if (c == '\r' || c == '\n') {
             enterPressed();
         }
     }

}