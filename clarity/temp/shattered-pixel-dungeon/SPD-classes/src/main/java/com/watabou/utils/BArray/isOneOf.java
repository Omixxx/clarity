class Snippet {
        public static boolean[] isOneOf(int[] a, boolean[] result, int... v){
            int length = a.length;
            int nv = v.length;
            if (result == null) {
                result = new boolean[length];
            }
            for (int i = 0; i < length; i++) {
                result[i] = false;
                for (int j = 0; j < nv; j++) {
                    if (a[i] == v[j]) {
                        result[i] = true;
                        break;
                    }
                }
            }
            return result;
        }
}