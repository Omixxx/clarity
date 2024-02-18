class Snippet {
        public synchronized boolean touchDragged(int screenX, int screenY, int pointer){
            PointerEvent.addIfExisting(new PointerEvent(screenX, screenY, pointer, PointerEvent.Type.DOWN));
            return true;
        }

}