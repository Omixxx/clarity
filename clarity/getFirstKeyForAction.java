class Snippet {
      public static int getFirstKeyForAction(GameAction action, boolean preferController){
          ArrayList<Integer> keys = getKeyboardKeysForAction(action);
          ArrayList<Integer> buttons = getControllerKeysForAction(action);
          if (preferController) {
              if (!buttons.isEmpty())
                  return buttons.get(0);
          } else {
              if (!keys.isEmpty())
                  return keys.get(0);
          }
          return 0;
      }

}