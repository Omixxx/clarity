class Snippet {
       public boolean axisMoved(Controller controller, int axisCode, float value){
           setControllerType(controller);
           ControllerMapping mapping = controller.getMapping();
           if (mapping.axisRightX == axisCode)
               rightStickPosition.x = value;
           else if (mapping.axisRightY == axisCode)
               rightStickPosition.y = value;
           else if (mapping.axisLeftX == axisCode)
               leftStickPosition.x = value;
           else if (mapping.axisLeftY == axisCode)
               leftStickPosition.y = value;
           else //L2 and R2 triggers on Desktop
           if (axisCode == 4 && Gdx.app.getType() == Application.ApplicationType.Desktop && L2Trigger != value) {
               if (value == 1) {
                   KeyEvent.addKeyEvent(new KeyEvent(Input.Keys.BUTTON_L2, true));
                   controllerActive = true;
               } else if (value == 0) {
                   KeyEvent.addKeyEvent(new KeyEvent(Input.Keys.BUTTON_L2, false));
                   controllerActive = true;
               }
               L2Trigger = value;
           } else if (axisCode == 5 && Gdx.app.getType() == Application.ApplicationType.Desktop && R2Trigger != value) {
               if (value == 1) {
                   KeyEvent.addKeyEvent(new KeyEvent(Input.Keys.BUTTON_R2, true));
                   controllerActive = true;
               } else if (value == 0) {
                   KeyEvent.addKeyEvent(new KeyEvent(Input.Keys.BUTTON_R2, false));
                   controllerActive = true;
               }
               R2Trigger = value;
           }
           return true;
       }

}