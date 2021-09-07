/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Asus
 */
public class Department implements Serializable{
    private static final long serialVersionUID = 1L;
    private int deptId;
    private String deptName;
    private String deptNo;
    private String location;

    public Department() {
    }

    public Department(int deptId, String deptName, String deptNo, String location) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.deptNo = deptNo;
        this.location = location;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    public Object[] toObjects(){
        return new Object[]{deptId,deptName,deptNo,location};
    }

    @Override
    public String toString() {
        return "Department{" + "deptId=" + deptId + ", deptName=" + deptName + ", deptNo=" + deptNo + ", location=" + location + '}';
    }
    
}
