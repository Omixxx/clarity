class Snippet {
      public synchronized Gizmo replace(Gizmo oldOne, Gizmo newOne){
          int index = members.indexOf(oldOne);
          if (index != -1) {
              members.set(index, newOne);
              newOne.parent = this;
              oldOne.parent = null;
              return newOne;
          } else {
              return null;
          }
      }

}