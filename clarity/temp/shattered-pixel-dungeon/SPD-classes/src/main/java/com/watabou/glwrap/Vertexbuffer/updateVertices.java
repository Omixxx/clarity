class Snippet {
       public void updateVertices(FloatBuffer vertices, int start, int end){
           this.vertices = vertices;
           if (updateStart == -1)
               updateStart = start;
           else
               updateStart = Math.min(start, updateStart);
           if (updateEnd == -1)
               updateEnd = end;
           else
               updateEnd = Math.max(end, updateEnd);
       }
}