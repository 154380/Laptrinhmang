package thread.com.syn;
public class Producer extends Thread {

    private SharedData sharedData;
    private int number;

    public Producer(SharedData c, int number) {
    	sharedData = c;
        this.number = number;
    }

    
    public void run() {
        for (int i = 0; i < 10; i++) {
        	sharedData.put(number, i);
            try {
                sleep((int)(Math.random() * 1000));
            } catch (InterruptedException e) { }
        }
    }
}