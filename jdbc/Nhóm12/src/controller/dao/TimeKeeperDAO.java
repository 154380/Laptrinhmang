/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Timekeeper;

public class TimeKeeperDAO implements ITimeKeeperDAO {

    private String jdbcURL = "jdbc:mysql://localhost:3306/contactdb?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    private static final String SELECT_ALL_TIMEKEEPER = "select * from timekeeper";

    public TimeKeeperDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public List<Timekeeper> selectAllTimekeepers() {
        List<Timekeeper> timekeepers = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement
                = connection.prepareStatement(SELECT_ALL_TIMEKEEPER);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String timeid = rs.getString("Timekeeper_Id");
                Date ts1 = rs.getDate("Date_Time");
                String inout = rs.getString("In_Out");
                long empID = rs.getLong("EMP_ID");
                timekeepers.add(new Timekeeper(timeid, ts1, inout, empID));

            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return timekeepers;
    }

    public void insertTimekeeper(Timekeeper timekeeper) throws ClassNotFoundException, SQLException {
        String foreign_key = "SET FOREIGN_KEY_CHECKS=0;";
        String insertSql = "Insert into timekeeper(Timekeeper_Id, Date_Time, In_Out, Emp_Id) "
                + " values (?,?,?,?) ";
        System.out.println(insertSql);
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.addBatch(foreign_key);
            preparedStatement.setString(1, timekeeper.getTimeID());
            preparedStatement.setDate(2, new Date(System.currentTimeMillis()));
            preparedStatement.setString(3, timekeeper.getInout());
            preparedStatement.setLong(4, timekeeper.getEmpID());
            preparedStatement.addBatch();
            System.out.println(preparedStatement);
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean deleteTimeKeeper(String id) throws SQLException {
        boolean check = false;
        String deleteTimeKeeper = "delete from timekeeper where Timekeeper_Id = ?;";
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(deleteTimeKeeper);
            preparedStatement.setString(1, id);
            preparedStatement.execute();
        } catch (Exception e) {
            check = false;
            e.printStackTrace();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return check;
    }

    @Override
    public boolean updateTimeKeeper(Timekeeper timekeeper) throws SQLException {
        boolean check = true;
        String foreign_key = "SET FOREIGN_KEY_CHECKS=0;";
        String updateTimeKeeper = "update timekeeper set Date_Time = ?,In_Out = ?, EMP_ID =? where Timekeeper_Id = ?;";
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(updateTimeKeeper);
            preparedStatement.addBatch(foreign_key);
            preparedStatement.setDate(1, new Date(System.currentTimeMillis()));
            preparedStatement.setString(2, timekeeper.getInout());
            preparedStatement.setLong(3, timekeeper.getEmpID());
            preparedStatement.setString(4, timekeeper.getTimeID());
            preparedStatement.addBatch();
            preparedStatement.executeBatch();
        } catch (Exception e) {
            check = false;
            e.printStackTrace();
        }
        //throw new UnsupportedOperationException("Not supported yet.");
        return check;
    }
}
