/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.CalculatorModel;
import view.CalculatorView;



public class CalculatorController implements ActionListener{
    private CalculatorView view;
    private CalculatorModel model;
    
    public CalculatorController(CalculatorView view, CalculatorModel model){
        this.view = view;
        this.model = model;
        this.view.addCalculateListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Float firstOperand, secondOperand;
        String operator;
        try {
            firstOperand = view.getFirstOperand();
            secondOperand = view.getSecondOperand();     
            operator = view.getCombobox();
            view.setResult(model.calculate(firstOperand , secondOperand , operator ));
        } catch (NumberFormatException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(view, "Enter the correct number format!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex);
        }
    }
    
}
