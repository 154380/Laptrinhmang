package thread.com.unsyn;

public class Producer extends Thread {
    private SharedData shareData;
    private int number;

    public Producer(SharedData c, int number) {
        shareData = c;
        this.number = number;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            shareData.put(i);
            System.out.println("Producer #" + this.number
                               + " put: " + i);
            try {
                sleep((int)(Math.random() * 100));
            } catch (InterruptedException e) { }
        }
    }
}