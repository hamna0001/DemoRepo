package com.example.calculator;

public class Calculator {
    private double firstOperand = 0, secondOperand = 0;
    private char operator;

    public double getFirstOperand() {
        return firstOperand;
    }

    public void setFirstOperand(double firstOperand) {
        this.firstOperand = firstOperand;
    }

    public double getSecondOperand() {
        return secondOperand;
    }

    public void setSecondOperand(double secondOperand) {
        this.secondOperand = secondOperand;
    }

    public char getOperator() {
        return operator;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }
    private  String secondOperands ;

    public double calculate(){
        switch (getOperator()){
            case '/': return  getFirstOperand() / getSecondOperand();
            case '*': return  getFirstOperand() * getSecondOperand();
            case '+': return  getFirstOperand() + getSecondOperand();
            case '-': return  getFirstOperand() - getSecondOperand();
            case '%': if(getSecondOperand() == 0) {
                return getFirstOperand() / 100;
            }else{
                return (getFirstOperand() / getSecondOperand())*100;
            }
            default :  return 0.0;
        }
    }
}
