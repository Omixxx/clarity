class Snippet {
        public static boolean[] and(boolean[] a, boolean[] b, boolean[] result){
            int length = a.length;
            if (result == null) {
                result = new boolean[length];
            }
            for (int i = 0; i < length; i++) {
                result[i] = a[i] && b[i];
            }
            return result;
        }

}