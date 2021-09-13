package thread.com.unsyn;


public class Consumer extends Thread {
    private SharedData sharedData;
    private int number;

    public Consumer(SharedData c, int number) {
        sharedData = c;
        this.number = number;
    }

    public void run() {
        int value = 0;
        for (int i = 0; i < 10; i++) {
            value = sharedData.get();
            System.out.println("Consumer #" + this.number
                               + " got: " + value);
        }
    }
}
