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
public class Hour extends Thread{
    private TimeFrame timeFrame;
    private int count;
    
    public Hour(TimeFrame timeFrame){
        super();
        this.timeFrame = timeFrame;
        count = 0;
    }
    
    public void increase(){
        count++;
        timeFrame.setHour(count);
    }
    
    public void run(){
        while(true){
            try{
                timeFrame.setHour(count);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

}
