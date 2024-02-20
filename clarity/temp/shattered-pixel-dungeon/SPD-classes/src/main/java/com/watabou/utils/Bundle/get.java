class Snippet {
  private Bundlable get(){
      if (data == null)
          return null;
      String clName = getString(CLASS_NAME);
      if (aliases.containsKey(clName)) {
          clName = aliases.get(clName);
      }
      Class<?> cl = Reflection.forName(clName);
      //Skip none-static inner classes as they can't be instantiated through bundle restoring
      //Classes which make use of none-static inner classes must manage instantiation manually
      if (cl != null && (!Reflection.isMemberClass(cl) || Reflection.isStatic(cl))) {
          Bundlable object = (Bundlable) Reflection.newInstance(cl);
          if (object != null) {
              object.restoreFromBundle(this);
              return object;
          }
      }
      return null;
  }
}