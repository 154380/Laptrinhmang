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
public class Minute extends Thread{
    private TimeFrame timeFrame;
    private Hour hour;
    private int count;
    
    public Minute(TimeFrame timeFrame, Hour hour){
        super();
        this.timeFrame = timeFrame;
        this.hour = hour;
        count = 0;
    }
    
    public void increase(){
        count++;
        if(count == 60){
            hour.increase(); 
            count = 0;
        }
        timeFrame.setMinute(count);
    }

    public void run(){
        while(true){
            try{
                timeFrame.setMinute(count);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

}
