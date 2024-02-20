class Snippet {
  public Camera camera(){
      if (camera != null) {
          return camera;
      } else if (parent != null) {
          return this.camera = parent.camera();
      } else {
          return null;
      }
  }
}