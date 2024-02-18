class Snippet {
       public void start(Factory factory, float interval, int quantity){
           this.factory = factory;
           this.lightMode = factory.lightMode();
           this.interval = interval;
           this.quantity = quantity;
           count = 0;
           time = Random.Float(interval);
           on = true;
           started = true;
       }

}