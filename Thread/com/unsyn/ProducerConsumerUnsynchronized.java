package thread.com.unsyn;

public class ProducerConsumerUnsynchronized {

    public static void main(String[] args) {
        
        SharedData c = new SharedData();
        
        Producer p1 = new Producer(c, 1);
        Consumer c1 = new Consumer(c, 1);

        p1.start();
        c1.start();
    }
}