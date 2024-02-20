class Snippet {
        public static float gate(float min, float value, float max){
            if (value < min) {
                return min;
            } else if (value > max) {
                return max;
            } else {
                return value;
            }
        }
}