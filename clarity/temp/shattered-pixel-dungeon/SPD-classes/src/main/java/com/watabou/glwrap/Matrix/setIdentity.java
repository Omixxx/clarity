class Snippet {
    public static void setIdentity(float[] m){
        System.arraycopy(identity, 0, m, 0, identity.length);
    }
}