class Snippet {
   public synchronized void destroy(){
       super.destroy();
       if (stage != null) {
           stage.dispose();
           skin.dispose();
           Game.inputHandler.removeInputProcessor(stage);
           Game.platform.setOnscreenKeyboardVisible(false);
           if (!DeviceCompat.isDesktop())
               Game.platform.updateSystemUI();
       }
   }
}