/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao;

import java.sql.SQLException;
import java.util.List;
import model.Department;

/**
 *
 * @author Asus
 */
public interface IDepartmentDAO {
    public void insertDepartment(Department department) throws SQLException;

//    public Department selectDepartment(int id);

    public List<Department> selectAllDepartments();

    public boolean deleteDepartment(int id) throws SQLException;

    public boolean updateDepartment(Department department) throws SQLException;

}
