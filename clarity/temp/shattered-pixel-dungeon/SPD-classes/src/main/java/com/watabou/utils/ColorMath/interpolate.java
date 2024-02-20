class Snippet {
        public static int interpolate(int A, int B, float p){
            if (p <= 0) {
                return A;
            } else if (p >= 1) {
                return B;
            }
            int ra = A >> 16;
            int ga = (A >> 8) & 0xFF;
            int ba = A & 0xFF;
            int rb = B >> 16;
            int gb = (B >> 8) & 0xFF;
            int bb = B & 0xFF;
            float p1 = 1 - p;
            int r = (int) (p1 * ra + p * rb);
            int g = (int) (p1 * ga + p * gb);
            int b = (int) (p1 * ba + p * bb);
            return (r << 16) + (g << 8) + b;
        }
}