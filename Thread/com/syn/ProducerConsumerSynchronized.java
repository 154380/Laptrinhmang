package thread.com.syn;

public class ProducerConsumerSynchronized {

    public static void main(String[] args) {
        
        SharedData c = new SharedData();
        
        Producer p1 = new Producer(c, 1);
        Consumer c1 = new Consumer(c, 1);
        
        c1.start();    
        p1.start();

    }
}
