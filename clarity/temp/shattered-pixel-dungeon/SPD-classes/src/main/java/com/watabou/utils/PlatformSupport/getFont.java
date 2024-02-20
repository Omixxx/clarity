class Snippet {
         public BitmapFont getFont(int size, String text, boolean flipped, boolean border){
             FreeTypeFontGenerator generator = getGeneratorForString(text);
             if (generator == null) {
                 return null;
             }
             int key = size;
             //surely we'll never have a size above 32k
             if (border)
                 key += Short.MAX_VALUE;
             if (flipped)
                 key = -key;
             if (!fonts.get(generator).containsKey(key)) {
                 FreeTypeFontGenerator.FreeTypeFontParameter parameters = new FreeTypeFontGenerator.FreeTypeFontParameter();
                 parameters.size = size;
                 parameters.flip = flipped;
                 if (border) {
                     parameters.borderWidth = parameters.size / 10f;
                 }
                 if (size >= 20) {
                     parameters.renderCount = 2;
                 } else {
                     parameters.renderCount = 3;
                 }
                 parameters.hinting = FreeTypeFontGenerator.Hinting.None;
                 parameters.spaceX = -(int) parameters.borderWidth;
                 parameters.incremental = true;
                 parameters.characters = "�";
                 parameters.packer = packer;
                 try {
                     BitmapFont font = generator.generateFont(parameters);
                     font.getData().missingGlyph = font.getData().getGlyph('�');
                     fonts.get(generator).put(key, font);
                 } catch (Exception e) {
                     Game.reportException(e);
                     return null;
                 }
             }
             return fonts.get(generator).get(key);
         }
}