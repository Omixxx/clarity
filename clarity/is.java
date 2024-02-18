class Snippet {
        public static boolean[] is(int[] a, boolean[] result, int v1){
            int length = a.length;
            if (result == null) {
                result = new boolean[length];
            }
            for (int i = 0; i < length; i++) {
                result[i] = a[i] == v1;
            }
            return result;
        }

}