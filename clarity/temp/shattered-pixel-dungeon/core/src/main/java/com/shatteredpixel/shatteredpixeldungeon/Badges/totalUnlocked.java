class Snippet {
    public static int totalUnlocked(boolean global){
        if (global)
            return Badges.global.size();
        else
            return Badges.local.size();
    }
}