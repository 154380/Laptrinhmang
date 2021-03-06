/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class CalculatorModel {

    public static float calculate(float firstOperand, float secondOperand, String operator ){
        switch (operator){
            case "Addition":
                return firstOperand + secondOperand;
            case "Subtraction":
                return firstOperand - secondOperand;
            case "Multiplication":
                return firstOperand * secondOperand;
            case "Division":
                if(secondOperand != 0)
                    return firstOperand / secondOperand;
                else
                    throw new RuntimeException("Can't divide by zero");
            default:
                throw new RuntimeException("Invalid operation");
        }
    }

}
