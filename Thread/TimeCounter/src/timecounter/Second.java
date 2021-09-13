/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timecounter;

/**
 *
 * @author Asus
 */
public class Second extends Thread{
    private TimeFrame timeFrame;
    private Minute minute;
    private int count;
    
    public Second(TimeFrame timeFrame, Minute minute){
        super();
        this.timeFrame = timeFrame;
        this.minute = minute;
        count = 0;
    }

    public void run(){
        while(true){
            try{
                this.sleep(1000);
                count++;
                if(count == 60){
                    count = 0;
                    minute.increase();
                }
                timeFrame.setSecond(count);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

}
