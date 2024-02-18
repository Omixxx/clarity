class Snippet {
    public static String showCompletionProgress(Badge badge){
        if (isUnlocked(badge))
            return null;
        String result = "\n";
        if (badge == Badge.BOSS_SLAIN_1_ALL_CLASSES) {
            for (HeroClass cls : HeroClass.values()) {
                result += "\n";
                if (isUnlocked(firstBossClassBadges.get(cls)))
                    result += "_" + Messages.titleCase(cls.title()) + "_";
                else
                    result += Messages.titleCase(cls.title());
            }
            return result;
        } else if (badge == Badge.VICTORY_ALL_CLASSES) {
            for (HeroClass cls : HeroClass.values()) {
                result += "\n";
                if (isUnlocked(victoryClassBadges.get(cls)))
                    result += "_" + Messages.titleCase(cls.title()) + "_";
                else
                    result += Messages.titleCase(cls.title());
            }
            return result;
        } else if (badge == Badge.BOSS_SLAIN_3_ALL_SUBCLASSES) {
            for (HeroSubClass cls : HeroSubClass.values()) {
                if (cls == HeroSubClass.NONE)
                    continue;
                result += "\n";
                if (isUnlocked(thirdBossSubclassBadges.get(cls)))
                    result += "_" + Messages.titleCase(cls.title()) + "_";
                else
                    result += Messages.titleCase(cls.title());
            }
            return result;
        }
        return null;
    }

}