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
public class TimeCounter {
    public static void main(String[] args) {
        TimeFrame timeFrame = new TimeFrame();
        timeFrame.setVisible(true);
        Hour hour = new Hour(timeFrame);
        Minute minute = new Minute(timeFrame, hour);
        Second second = new Second(timeFrame, minute);
        hour.start();
        minute.start();
        second.start();
    }
}
