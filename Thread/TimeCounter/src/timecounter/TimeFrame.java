/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timecounter;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;

/**
 *
 * @author Asus
 */
public class TimeFrame extends Frame{
    private JLabel lblTime;
    private int hour=0,minute=0,second=0;
    public TimeFrame(){
        super("Bộ đếm thời gian");
        this.setSize(350, 200);
        this.setResizable(false);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        lblTime =new JLabel(hour+":"+minute+":"+second);        
        lblTime.setSize(100, 100);
        lblTime.setFont(new Font("Serif", Font.BOLD,30));
        lblTime.setLocation(120,50);
        this.add(lblTime);
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    } 
    
    public void setHour(int hour) {
        this.hour = hour;
        lblTime.setText(hour+":"+minute+":"+second);
    }
    
    public void setMinute(int minute) {
        this.minute = minute;
        lblTime.setText(hour+":"+minute+":"+second);
    }
    
    public void setSecond(int second) {
        this.second = second;
        lblTime.setText(hour+":"+minute+":"+second);
    }
    
}
