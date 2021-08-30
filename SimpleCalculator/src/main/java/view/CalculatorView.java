/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorView extends JFrame{
    
    String[] operators = {"Addition","Subtraction","Multiplication","Division"};
    private JComboBox comboBox = new JComboBox(operators);
    private JTextField firstOperand = new JTextField(10);
    private JTextField secondOperand = new JTextField(10);
    private JButton btnSubmit = new JButton("Calculate");
    private JTextField result  = new JTextField(10);
    private JLabel labelResult = new JLabel("Result:");
    public CalculatorView() {
        JPanel panel = new JPanel(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,300);
        this.setTitle("Simple Calculator");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        firstOperand.setBounds(10, 20, 150, 30);
        comboBox.setBounds(10, 60, 120, 30);
        secondOperand.setBounds(10, 100, 150, 30);
        btnSubmit.setBounds(10, 140, 100, 30);
        result.setBounds(60, 180, 100, 30);
        labelResult.setBounds(10,180,50,30);
        result.setEditable(false);
        panel.add(firstOperand);
        panel.add(comboBox);
        panel.add(secondOperand);
        panel.add(btnSubmit);
        panel.add(labelResult);
        panel.add(result);
        this.add(panel);     
    }
    
    public Float getFirstOperand(){
        return Float.parseFloat(firstOperand.getText());
    }
    
    public String getCombobox(){
        return comboBox.getSelectedItem().toString();
    }
    
    public Float getSecondOperand(){
        return Float.parseFloat(secondOperand.getText());
    }
    
    public Float getResult(){
        return Float.parseFloat(result.getText());
    }
    
    public void setResult(float result){
        this.result.setText(Float.toString(result));
    }
    
    public void addCalculateListener(ActionListener e){
        btnSubmit.addActionListener(e);
    }
}

