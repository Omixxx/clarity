class Snippet {
   public static void saveBindings(){
       Bundle b = new Bundle();
       Bundle firstKeys = new Bundle();
       Bundle secondKeys = new Bundle();
       Bundle thirdKeys = new Bundle();
       for (GameAction a : allActions()) {
           int firstCur = 0;
           int secondCur = 0;
           int thirdCur = 0;
           int firstDef = 0;
           int secondDef = 0;
           int thirdDef = 0;
           for (int i : defaultBindings.keySet()) {
               if (defaultBindings.get(i) == a) {
                   if (firstDef == 0) {
                       firstDef = i;
                   } else if (secondDef == 0) {
                       secondDef = i;
                   } else {
                       thirdDef = i;
                   }
               }
           }
           LinkedHashMap<Integer, GameAction> curBindings = KeyBindings.getAllBindings();
           for (int i : curBindings.keySet()) {
               if (curBindings.get(i) == a) {
                   if (firstCur == 0) {
                       firstCur = i;
                   } else if (secondCur == 0) {
                       secondCur = i;
                   } else {
                       thirdCur = i;
                   }
               }
           }
           if (firstCur != firstDef) {
               firstKeys.put(a.name(), firstCur);
           }
           if (secondCur != secondDef) {
               secondKeys.put(a.name(), secondCur);
           }
           if (thirdCur != thirdDef) {
               thirdKeys.put(a.name(), thirdCur);
           }
       }
       b.put("first_keys", firstKeys);
       b.put("second_keys", secondKeys);
       b.put("third_keys", thirdKeys);
       Bundle firstButtons = new Bundle();
       Bundle secondButtons = new Bundle();
       Bundle thirdButtons = new Bundle();
       for (GameAction a : allActions()) {
           int firstCur = 0;
           int secondCur = 0;
           int thirdCur = 0;
           int firstDef = 0;
           int secondDef = 0;
           int thirdDef = 0;
           for (int i : defaultControllerBindings.keySet()) {
               if (defaultControllerBindings.get(i) == a) {
                   if (firstDef == 0) {
                       firstDef = i;
                   } else if (secondDef == 0) {
                       secondDef = i;
                   } else {
                       thirdDef = i;
                   }
               }
           }
           LinkedHashMap<Integer, GameAction> curBindings = KeyBindings.getAllControllerBindings();
           for (int i : curBindings.keySet()) {
               if (curBindings.get(i) == a) {
                   if (firstCur == 0) {
                       firstCur = i;
                   } else if (secondCur == 0) {
                       secondCur = i;
                   } else {
                       thirdCur = i;
                   }
               }
           }
           if (firstCur != firstDef) {
               firstButtons.put(a.name(), firstCur);
           }
           if (secondCur != secondDef) {
               secondButtons.put(a.name(), secondCur);
           }
           if (thirdCur != thirdDef) {
               thirdButtons.put(a.name(), thirdCur);
           }
       }
       b.put("first_keys_controller", firstButtons);
       b.put("second_keys_controller", secondButtons);
       b.put("third_keys_controller", thirdButtons);
       try {
           FileUtils.bundleToFile(BINDINGS_FILE, b);
       } catch (IOException e) {
           ShatteredPixelDungeon.reportException(e);
       }
   }

}