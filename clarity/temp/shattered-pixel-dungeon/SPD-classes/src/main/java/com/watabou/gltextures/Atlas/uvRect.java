class Snippet {
            public static RectF uvRect(SmartTexture tx, int left, int top, int right, int bottom){
                return new RectF((float) left / tx.width, (float) top / tx.height, (float) right / tx.width, (float) bottom / tx.height);
            }
}