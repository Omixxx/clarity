class Snippet {
      public static int buttonToKey(Controller controller, int btnCode){
          ControllerMapping mapping = controller.getMapping();
          if (btnCode == mapping.buttonA)
              return Input.Keys.BUTTON_A;
          if (btnCode == mapping.buttonB)
              return Input.Keys.BUTTON_B;
          //C button?
          if (btnCode == mapping.buttonX)
              return Input.Keys.BUTTON_X;
          if (btnCode == mapping.buttonY)
              return Input.Keys.BUTTON_Y;
          if (btnCode == mapping.buttonBack)
              return Input.Keys.BUTTON_SELECT;
          if (btnCode == mapping.buttonStart)
              return Input.Keys.BUTTON_START;
          if (btnCode == mapping.buttonL1)
              return Input.Keys.BUTTON_L1;
          if (btnCode == mapping.buttonL2)
              return Input.Keys.BUTTON_L2;
          if (btnCode == mapping.buttonR1)
              return Input.Keys.BUTTON_R1;
          if (btnCode == mapping.buttonR2)
              return Input.Keys.BUTTON_R2;
          if (btnCode == mapping.buttonDpadUp)
              return Input.Keys.DPAD_UP + DPAD_KEY_OFFSET;
          if (btnCode == mapping.buttonDpadDown)
              return Input.Keys.DPAD_DOWN + DPAD_KEY_OFFSET;
          if (btnCode == mapping.buttonDpadLeft)
              return Input.Keys.DPAD_LEFT + DPAD_KEY_OFFSET;
          if (btnCode == mapping.buttonDpadRight)
              return Input.Keys.DPAD_RIGHT + DPAD_KEY_OFFSET;
          if (btnCode == mapping.buttonLeftStick)
              return Input.Keys.BUTTON_THUMBL;
          if (btnCode == mapping.buttonRightStick)
              return Input.Keys.BUTTON_THUMBR;
          return Input.Keys.UNKNOWN;
      }
}