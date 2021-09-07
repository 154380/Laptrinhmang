/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Department;

/**
 *
 * @author Asus
 */
public class DepartmentDAO implements IDepartmentDAO{
    private String jdbcURL ="jdbc:mysql://localhost:3306/contactdb?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";
    
    private static final String SELECT_ALL_DEPARTMENTS = "select * from department";
    private static final String INSERT_DEPARTMENTS_SQL= "INSERT INTO department" 
            + "  (DEPT_ID, DEPT_NAME, DEPT_NO, LOCATION) VALUES "
            + " (?, ?, ?, ?)";
    private static final String DELETE_DEPARTMENTS_SQL = "delete from department where DEPT_ID = ?;";
    private static final String UPDATE_DEPARTMENTS_SQL = "update department set DEPT_NAME = ?,DEPT_NO = ?, LOCATION =? where DEPT_ID = ?;";
    
    public DepartmentDAO() {
    }
    
    protected Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }   

    public List<Department> selectAllDepartments() {
        List<Department> departments = new ArrayList<>();
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DEPARTMENTS);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("DEPT_ID");
                String name = rs.getString("DEPT_NAME");
                String no = rs.getString("DEPT_NO");
                String location = rs.getString("LOCATION");
                departments.add(new Department(id , name , no , location));
            }
        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return departments;
    }
    
    public void insertDepartment(Department department)throws SQLException{
        System.out.println(INSERT_DEPARTMENTS_SQL);
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DEPARTMENTS_SQL);){
            preparedStatement.setInt(1,department.getDeptId());
            preparedStatement.setString(2,department.getDeptName());
            preparedStatement.setString(3,department.getDeptNo());
            preparedStatement.setString(4,department.getLocation());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public boolean deleteDepartment(int id) throws SQLException {
        boolean rowDeleted;
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(DELETE_DEPARTMENTS_SQL);){
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() >0 ;
        }
        return rowDeleted;
    }
    
    public boolean updateDepartment(Department department) throws SQLException{
        boolean rowUpdated;
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DEPARTMENTS_SQL);){
            preparedStatement.setString(1,department.getDeptName());
            preparedStatement.setString(2,department.getDeptNo());
            preparedStatement.setString(3,department.getLocation());
            preparedStatement.setInt(4,department.getDeptId());
            rowUpdated = preparedStatement.executeUpdate() >0;
        }
        return rowUpdated;
    }
}
