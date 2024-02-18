class Snippet {
        public static String depthFile(int slot, int depth, int branch){
            if (branch == 0) {
                return gameFolder(slot) + "/" + Messages.format(DEPTH_FILE, depth);
            } else {
                return gameFolder(slot) + "/" + Messages.format(DEPTH_BRANCH_FILE, depth, branch);
            }
        }

}