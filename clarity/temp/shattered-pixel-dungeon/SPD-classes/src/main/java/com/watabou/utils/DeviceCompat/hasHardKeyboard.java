class Snippet {
   public static boolean hasHardKeyboard(){
       return Gdx.input.isPeripheralAvailable(Input.Peripheral.HardwareKeyboard);
   }
}