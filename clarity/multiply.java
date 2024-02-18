class Snippet {
        public static void multiply(float[] left, float[] right, float[] result){
            final float ax1 = left[0];
            final float ay1 = left[1];
            final float az1 = left[2];
            final float aw1 = left[3];
            final float ax2 = left[4];
            final float ay2 = left[5];
            final float az2 = left[6];
            final float aw2 = left[7];
            final float ax3 = left[8];
            final float ay3 = left[9];
            final float az3 = left[10];
            final float aw3 = left[11];
            final float ax4 = left[12];
            final float ay4 = left[13];
            final float az4 = left[14];
            final float aw4 = left[15];
            final float bx1 = right[0];
            final float by1 = right[1];
            final float bz1 = right[2];
            final float bw1 = right[3];
            final float bx2 = right[4];
            final float by2 = right[5];
            final float bz2 = right[6];
            final float bw2 = right[7];
            final float bx3 = right[8];
            final float by3 = right[9];
            final float bz3 = right[10];
            final float bw3 = right[11];
            final float bx4 = right[12];
            final float by4 = right[13];
            final float bz4 = right[14];
            final float bw4 = right[15];
            result[0] = ax1 * bx1 + ax2 * by1 + ax3 * bz1 + ax4 * bw1;
            result[1] = ay1 * bx1 + ay2 * by1 + ay3 * bz1 + ay4 * bw1;
            result[2] = az1 * bx1 + az2 * by1 + az3 * bz1 + az4 * bw1;
            result[3] = aw1 * bx1 + aw2 * by1 + aw3 * bz1 + aw4 * bw1;
            result[4] = ax1 * bx2 + ax2 * by2 + ax3 * bz2 + ax4 * bw2;
            result[5] = ay1 * bx2 + ay2 * by2 + ay3 * bz2 + ay4 * bw2;
            result[6] = az1 * bx2 + az2 * by2 + az3 * bz2 + az4 * bw2;
            result[7] = aw1 * bx2 + aw2 * by2 + aw3 * bz2 + aw4 * bw2;
            result[8] = ax1 * bx3 + ax2 * by3 + ax3 * bz3 + ax4 * bw3;
            result[9] = ay1 * bx3 + ay2 * by3 + ay3 * bz3 + ay4 * bw3;
            result[10] = az1 * bx3 + az2 * by3 + az3 * bz3 + az4 * bw3;
            result[11] = aw1 * bx3 + aw2 * by3 + aw3 * bz3 + aw4 * bw3;
            result[12] = ax1 * bx4 + ax2 * by4 + ax3 * bz4 + ax4 * bw4;
            result[13] = ay1 * bx4 + ay2 * by4 + ay3 * bz4 + ay4 * bw4;
            result[14] = az1 * bx4 + az2 * by4 + az3 * bz4 + az4 * bw4;
            result[15] = aw1 * bx4 + aw2 * by4 + aw3 * bz4 + aw4 * bw4;
        }

}