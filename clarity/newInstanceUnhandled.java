class Snippet {
      public static T newInstanceUnhandled(Class<T> cls) throws Exception{
          return ClassReflection.newInstance(cls);
      }

}