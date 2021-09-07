package model;

import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the TIMEKEEPER database table.
 *
 */
public class Timekeeper implements Serializable {

    private static final long serialVersionUID = 1L;

    private String timeID;
    private Date dateTime;
    private String inout;
    private long empID;

    public Timekeeper(){
    }
    
    public Timekeeper(String timeID, Date dateTime, String inout, long empID) {
        this.timeID = timeID;
        this.dateTime = dateTime;
        this.inout = inout;
        this.empID = empID;
    }

    public String getTimeID() {
        return timeID;
    }

    public void setTimeID(String timeID) {
        this.timeID = timeID;
    }

    public Date getDateTime() {
        return this.dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getInout() {
        return this.inout;
    }

    public void setInout(String inout) {
        this.inout = inout;
    }

    public long getEmpID() {
        return empID;
    }

    public void setEmpID(long empID) {
        this.empID = empID;
    }
    
    public Object[] toObjects(){
        return new Object[]{timeID,dateTime,inout,empID};
    }

    @Override
    public String toString() {
        return "Timekeeper{"
                + "timeID=" + timeID + ", "
                + "dateTime=" + dateTime + ", "
                + "inout=" + inout + ", "
                + "empID=" + empID + '}';
    }
}
