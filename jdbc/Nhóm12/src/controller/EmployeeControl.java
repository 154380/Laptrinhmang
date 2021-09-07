package controller;

import java.sql.SQLException;

import controller.dao.EmployeeDAO;
import controller.utils.ConnectionUtils;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Employee;
import view.EmployeeView;

public class EmployeeControl {
    EmployeeView view;
    EmployeeDAO dao;
    Employee[] employees;
    public EmployeeControl(EmployeeView view) {
        try {
            dao = new EmployeeDAO(ConnectionUtils.getMyConnection());
            this.view = view;
            
            employees = this.dao.selectAll();
            view.setRowCount(0);
            for(Employee i:employees){
                view.addRow(i.toObjects());
            }
            
            view.addEmployeeListener(new AddEmployeeListener(dao));
            view.editEmployeeListener(new EditEmployeeListener(dao));
            view.deleteEmployeeListener(new DeleteEmployeeListener(dao));

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            this.dao.closeConnection();
            System.exit(0);
        }
    }

    class AddEmployeeListener implements ActionListener {
        EmployeeDAO dao;
        
        public AddEmployeeListener(EmployeeDAO dao) {
            this.dao=dao;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Employee employee = view.getEmployee();
                int rowCount = this.dao.insert(employee);
                if(rowCount!=0) {
                    employees = this.dao.selectAll();
                    view.setRowCount(0);
                    for(Employee i:employees){
                        view.addRow(i.toObjects());
                    }                    
                }
                view.reset();
                view.showMessage(rowCount+ " nhân viên được thêm mới"); 
            } catch (Exception ex) {
                view.showMessage("0 nhân viên được thêm mới");
                Logger.getLogger(EmployeeControl.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
    class EditEmployeeListener implements ActionListener {
        EmployeeDAO dao;
        
        public EditEmployeeListener(EmployeeDAO dao) {
            this.dao=dao;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Employee employee = view.getEmployee();
                System.out.println(employee.getHireDate());
                int updateCount = this.dao.update(employee); 
                if(updateCount!=0) {
                    view.update();
                }
                view.reset();
                view.showMessage(updateCount+ " nhân viên được sửa"); 
            } catch (Exception ex) {
                view.showMessage("0 nhân viên được sửa");
                Logger.getLogger(EmployeeControl.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
    class DeleteEmployeeListener implements ActionListener {
        EmployeeDAO dao;
        
        public DeleteEmployeeListener(EmployeeDAO dao) {
            this.dao=dao;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Employee employee = view.getEmployee();
                int deleteCount = this.dao.delete(employee);
                if(deleteCount!=0) {
                    view.remove();
                }
                view.reset();
                view.showMessage(deleteCount+ " nhân viên được xóa"); 
            } catch (Exception ex) {
                view.showMessage("0 nhân viên được xóa"); 
                Logger.getLogger(EmployeeControl.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
}
