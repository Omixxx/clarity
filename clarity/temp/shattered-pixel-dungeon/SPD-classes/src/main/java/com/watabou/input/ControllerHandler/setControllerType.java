class Snippet {
    private static void setControllerType(Controller controller){
        if (controller.getName().contains("Xbox")) {
            lastUsedType = ControllerType.XBOX;
        } else if (controller.getName().contains("PS")) {
            lastUsedType = ControllerType.PLAYSTATION;
        } else if (controller.getName().contains("Nintendo")) {
            lastUsedType = ControllerType.NINTENDO;
        } else {
            lastUsedType = ControllerType.OTHER;
        }
    }
}