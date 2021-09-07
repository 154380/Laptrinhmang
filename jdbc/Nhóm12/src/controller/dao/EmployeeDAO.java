package controller.dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Employee;

public class EmployeeDAO extends IGeneralDAO<Employee> {
    public EmployeeDAO(Connection con) {
        this.con = con;
        try {
            this.statement = this.con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee[] selectAll() {
        Vector<Employee> employee = new Vector<Employee>();
        Employee[] result;
        try {
            String sql = "Select * from Employee";

            rs = statement.executeQuery(sql);
            int i = 0;
            while (rs.next()) {
                Employee e = new Employee(
                                rs.getInt(1), 
                                rs.getString(2),
                                rs.getString(3),
                                rs.getDate(4),
                                rs.getBytes(5),
                                rs.getString(6),
                                rs.getFloat(7),
                                rs.getInt(8),
                                BigInteger.valueOf(rs.getInt(9)));
                employee.add(e);

                i++;
            }
            result = new Employee[i];
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return employee.toArray(result);
    }

    @Override
    public int insert(Employee e) {
                int rowCount =1;
                String foreign_key = "SET FOREIGN_KEY_CHECKS=0;";
		String sql = "INSERT INTO EMPLOYEE (EMP_ID,"+
				"EMP_NAME,"+
				"EMP_NO,"+
				"HIRE_DATE,"+
				"IMAGE,"+
				"JOB,"+
				"SALARY,"+
				"DEPT_ID,"+
				"MNG_ID)"+
				"VALUES (?,?,?,?,?,?,?,?,?)";
		try {
			this.preStatement = this.con.prepareStatement(sql);
                        this.preStatement.addBatch(foreign_key);
			this.preStatement.setInt(1, e.getEmpId());
			this.preStatement.setString(2, e.getEmpName());
			this.preStatement.setString(3, e.getEmpNo());
			this.preStatement.setDate(4, new java.sql.Date(e.getHireDate().getTime()));
			this.preStatement.setBytes(5, e.getImage());
			this.preStatement.setString(6, e.getJob());
			this.preStatement.setFloat(7, e.getSalary());
			this.preStatement.setInt(8, e.getDeptId());
			this.preStatement.setLong(9, e.getMngId().longValue());
                        this.preStatement.addBatch();
			this.preStatement.executeBatch();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
			return 0;
			
        }
        return rowCount;
    }

    @Override
    public int update(Employee e) {
        String sql = "UPDATE EMPLOYEE set "+
                        "EMP_NAME = ?,"+
                        "EMP_NO = ?,"+
                        "HIRE_DATE = ?,"+
                        "IMAGE= ?,"+
                        "JOB= ?,"+
                        "SALARY = ?,"+
                        "DEPT_ID = ?,"+
                        "MNG_ID= ? "+
                        "Where EMP_ID = ?";
        try {
            this.preStatement = this.con.prepareStatement(sql);
            this.preStatement.setString(1, e.getEmpName());
            this.preStatement.setString(2, e.getEmpNo());
            this.preStatement.setDate(3, new java.sql.Date(e.getHireDate().getTime()));
            this.preStatement.setBytes(4, e.getImage());
            this.preStatement.setString(5, e.getJob());
            this.preStatement.setFloat(6, e.getSalary());
            this.preStatement.setInt(7, e.getDeptId());
            this.preStatement.setLong(8, e.getMngId().longValue());
            this.preStatement.setInt(9, e.getEmpId());

            int rowCount=this.preStatement.executeUpdate();

            return rowCount;
        } catch (SQLException e1) {
            e1.printStackTrace();
            return 0;
        }
    }

    @Override
    public void closeConnection() {
        try {
            this.con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int delete(Employee e) {
        String sql = "DELETE FROM EMPLOYEE WHERE EMP_ID=?";
        try {
            this.preStatement = this.con.prepareStatement(sql);
            this.preStatement.setInt(1, e.getEmpId());
            int rowCount=this.preStatement.executeUpdate();
            
            return rowCount;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

}
