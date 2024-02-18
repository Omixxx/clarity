class Snippet {
            public static boolean[] or(boolean[] a, boolean[] b, int offset, int length, boolean[] result){
                if (result == null) {
                    result = new boolean[length];
                }
                for (int i = offset; i < offset + length; i++) {
                    result[i] = a[i] || b[i];
                }
                return result;
            }

}