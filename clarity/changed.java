class Snippet {
     public void changed(ChangeEvent event, Actor actor){
         BitmapFont f = Game.platform.getFont(size, textField.getText(), false, false);
         TextField.TextFieldStyle style = textField.getStyle();
         if (f != style.font) {
             style.font = f;
             textField.setStyle(style);
         }
     }

}