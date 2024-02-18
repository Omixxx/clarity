class Snippet {
   public static void loadBindings(){
       if (!KeyBindings.getAllBindings().isEmpty()) {
           return;
       }
       try {
           Bundle b = FileUtils.bundleFromFile(BINDINGS_FILE);
           Bundle firstKeys = b.getBundle("first_keys");
           Bundle secondKeys = b.getBundle("second_keys");
           Bundle thirdKeys = b.getBundle("third_keys");
           LinkedHashMap<Integer, GameAction> defaults = getDefaults();
           LinkedHashMap<Integer, GameAction> merged = new LinkedHashMap<>();
           for (GameAction a : allActions()) {
               if (firstKeys.contains(a.name()) && !ControllerHandler.icControllerKey(firstKeys.getInt(a.name()))) {
                   if (firstKeys.getInt(a.name()) == 0) {
                       //we have no keys assigned to this action, move to the next one
                       continue;
                   } else {
                       merged.put(firstKeys.getInt(a.name()), a);
                       //remove whatever the first default key was for this action, if any
                       for (int i : defaults.keySet()) {
                           if (defaults.get(i) == a) {
                               defaults.remove(i);
                               break;
                           }
                       }
                   }
               } else {
                   //if we have no custom key here, find the first one from defaults and merge it
                   for (int i : defaults.keySet()) {
                       if (defaults.get(i) == a) {
                           merged.put(i, defaults.remove(i));
                           break;
                       }
                   }
               }
               if (secondKeys.contains(a.name()) && !ControllerHandler.icControllerKey(secondKeys.getInt(a.name()))) {
                   if (secondKeys.getInt(a.name()) == 0) {
                       //we have no more keys assigned to this action, move to the next one
                       continue;
                   } else {
                       merged.put(secondKeys.getInt(a.name()), a);
                       //remove whatever the second default key was for this action, if any
                       for (int i : defaults.keySet()) {
                           if (defaults.get(i) == a) {
                               defaults.remove(i);
                               break;
                           }
                       }
                   }
               } else {
                   //if we have no custom key here, find the next one from defaults and merge it
                   for (int i : defaults.keySet()) {
                       if (defaults.get(i) == a) {
                           merged.put(i, defaults.remove(i));
                           break;
                       }
                   }
               }
               if (thirdKeys.contains(a.name()) && !ControllerHandler.icControllerKey(thirdKeys.getInt(a.name()))) {
                   if (thirdKeys.getInt(a.name()) == 0) {
                       //we have no more keys assigned to this action, move to the next one
                       continue;
                   } else {
                       merged.put(thirdKeys.getInt(a.name()), a);
                       //remove whatever the third default key was for this action, if any
                       for (int i : defaults.keySet()) {
                           if (defaults.get(i) == a) {
                               defaults.remove(i);
                               break;
                           }
                       }
                   }
               } else {
                   //if we have no custom key here, find the next one from defaults and merge it
                   for (int i : defaults.keySet()) {
                       if (defaults.get(i) == a) {
                           merged.put(i, defaults.remove(i));
                           break;
                       }
                   }
               }
           }
           KeyBindings.setAllBindings(merged);
           defaults = getControllerDefaults();
           merged.clear();
           Bundle firstButtons = b.getBundle("first_keys_controller");
           Bundle secondButtons = b.getBundle("second_keys_controller");
           Bundle thirdButtons = b.getBundle("third_keys_controller");
           for (GameAction a : allActions()) {
               if (firstButtons.contains(a.name()) && ControllerHandler.icControllerKey(firstButtons.getInt(a.name()))) {
                   if (firstButtons.getInt(a.name()) == 0) {
                       //we have no keys assigned to this action, move to the next one
                       continue;
                   } else {
                       merged.put(firstButtons.getInt(a.name()), a);
                       //remove whatever the first default button was for this action, if any
                       for (int i : defaults.keySet()) {
                           if (defaults.get(i) == a) {
                               defaults.remove(i);
                               break;
                           }
                       }
                   }
               } else {
                   //if we have no custom key here, find the first one from defaults and merge it
                   for (int i : defaults.keySet()) {
                       if (defaults.get(i) == a) {
                           merged.put(i, defaults.remove(i));
                           break;
                       }
                   }
               }
               if (secondButtons.contains(a.name()) && ControllerHandler.icControllerKey(secondButtons.getInt(a.name()))) {
                   if (secondButtons.getInt(a.name()) == 0) {
                       //we have no more keys assigned to this action, move to the next one
                       continue;
                   } else {
                       merged.put(secondButtons.getInt(a.name()), a);
                       //remove whatever the second default button was for this action, if any
                       for (int i : defaults.keySet()) {
                           if (defaults.get(i) == a) {
                               defaults.remove(i);
                               break;
                           }
                       }
                   }
               } else {
                   //if we have no custom key here, find the next one from defaults and merge it
                   for (int i : defaults.keySet()) {
                       if (defaults.get(i) == a) {
                           merged.put(i, defaults.remove(i));
                           break;
                       }
                   }
               }
               if (thirdButtons.contains(a.name()) && ControllerHandler.icControllerKey(thirdButtons.getInt(a.name()))) {
                   if (thirdButtons.getInt(a.name()) == 0) {
                       //we have no more keys assigned to this action, move to the next one
                       continue;
                   } else {
                       merged.put(thirdButtons.getInt(a.name()), a);
                       //remove whatever the third default button was for this action, if any
                       for (int i : defaults.keySet()) {
                           if (defaults.get(i) == a) {
                               defaults.remove(i);
                               break;
                           }
                       }
                   }
               } else {
                   //if we have no custom key here, find the next one from defaults and merge it
                   for (int i : defaults.keySet()) {
                       if (defaults.get(i) == a) {
                           merged.put(i, defaults.remove(i));
                           break;
                       }
                   }
               }
           }
           KeyBindings.setAllControllerBindings(merged);
       } catch (Exception e) {
           KeyBindings.setAllBindings(getDefaults());
           KeyBindings.setAllControllerBindings(getControllerDefaults());
       }
   }

}