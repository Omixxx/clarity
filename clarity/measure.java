class Snippet {
   private synchronized void measure(){
       if (Thread.currentThread().getName().equals("SHPD Actor Thread")) {
           throw new RuntimeException("Text measured from the actor thread!");
       }
       if (text == null || text.equals("")) {
           text = "";
           width = height = 0;
           visible = false;
           return;
       } else {
           visible = true;
       }
       font = Game.platform.getFont(size, text, true, true);
       if (font != null) {
           GlyphLayout glyphs = new GlyphLayout(font, text);
           for (char c : text.toCharArray()) {
               BitmapFont.Glyph g = font.getData().getGlyph(c);
               if (g == null || (g.id != c)) {
                   String toException = text;
                   if (toException.length() > 30) {
                       toException = toException.substring(0, 30) + "...";
                   }
                   //reduces logspam
                   if (!alreadyReported.contains(c)) {
                       Game.reportException(new Throwable("font file " + font.toString() + " could not render " + c + " from string: " + toException));
                       alreadyReported.add(c);
                   }
               }
           }
           //We use the xadvance of the last glyph in some cases to fix issues
           // with fullwidth punctuation marks in some asian scripts
           BitmapFont.Glyph lastGlyph = font.getData().getGlyph(text.charAt(text.length() - 1));
           if (lastGlyph != null && lastGlyph.xadvance > lastGlyph.width * 1.5f) {
               width = glyphs.width - lastGlyph.width + lastGlyph.xadvance;
           } else {
               width = glyphs.width;
           }
           //this is identical to l.height in most cases, but we force this for consistency.
           height = Math.round(size * 0.75f);
           renderedHeight = glyphs.height;
       }
   }

}