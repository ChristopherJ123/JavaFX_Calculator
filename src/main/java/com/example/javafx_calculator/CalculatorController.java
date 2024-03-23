package com.example.javafx_calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.Objects;

public class CalculatorController {

    private String firstValue = "";
    private String secondValue = "";
    private String operator;

    @FXML
    private TextField calculatorTextField;

    void updateScreen() {
        this.calculatorTextField.setText(
                Double.parseDouble(firstValue) +
                        (operator != null ? " " + operator
                                + (!Objects.equals(secondValue, "") ? " " + Double.parseDouble(secondValue) : "")
                                : "")
        );
    }

    void pressButtonNumber(String number) {
        if (operator == null) {
            firstValue = firstValue.concat(number);
        } else {
            secondValue = secondValue.concat(number);
        }
        updateScreen();
    }

    void pressButtonOperator(String operator) {
        if (Objects.equals(firstValue, "")) return;
        if (this.operator == null) {
            if (!operator.equals("=")) {
                this.operator = operator;
            }
        } else {
            switch (this.operator) {
                case "+" -> firstValue = String.valueOf(Double.parseDouble(firstValue) + Double.parseDouble(secondValue));
                case "-" -> firstValue = String.valueOf(Double.parseDouble(firstValue) - Double.parseDouble(secondValue));
                case "×" -> firstValue = String.valueOf(Double.parseDouble(firstValue) * Double.parseDouble(secondValue));
                case "÷" -> firstValue = String.valueOf(Double.parseDouble(firstValue) / Double.parseDouble(secondValue));
            }
            this.operator = null;
            secondValue = "";
            pressButtonOperator(operator);
        }
        updateScreen();
    }

    @FXML
    void pressButton0(ActionEvent event) {
        pressButtonNumber(((Button) event.getSource()).getText());
    }

    @FXML
    void pressButton1(ActionEvent event) {
        pressButtonNumber(((Button) event.getSource()).getText());
    }

    @FXML
    void pressButton2(ActionEvent event) {
        pressButtonNumber(((Button) event.getSource()).getText());
    }

    @FXML
    void pressButton3(ActionEvent event) {
        pressButtonNumber(((Button) event.getSource()).getText());
    }

    @FXML
    void pressButton4(ActionEvent event) {
        pressButtonNumber(((Button) event.getSource()).getText());
    }

    @FXML
    void pressButton5(ActionEvent event) {
        pressButtonNumber(((Button) event.getSource()).getText());
    }

    @FXML
    void pressButton6(ActionEvent event) {
        pressButtonNumber(((Button) event.getSource()).getText());
    }

    @FXML
    void pressButton7(ActionEvent event) {
        pressButtonNumber(((Button) event.getSource()).getText());
    }

    @FXML
    void pressButton8(ActionEvent event) {
        pressButtonNumber(((Button) event.getSource()).getText());
    }

    @FXML
    void pressButton9(ActionEvent event) {
        pressButtonNumber(((Button) event.getSource()).getText());
    }

    @FXML
    void pressButtonDecimal(ActionEvent event) {
        pressButtonNumber(((Button) event.getSource()).getText());
    }

    @FXML
    void pressButtonAdd(ActionEvent event) {
        pressButtonOperator(((Button) event.getSource()).getText());
    }

    @FXML
    void pressButtonSubstract(ActionEvent event) {
        pressButtonOperator(((Button) event.getSource()).getText());
    }

    @FXML
    void pressButtonMultiply(ActionEvent event) {
        pressButtonOperator(((Button) event.getSource()).getText());
    }

    @FXML
    void pressButtonDivision(ActionEvent event) {
        pressButtonOperator(((Button) event.getSource()).getText());
    }

    @FXML
    void pressButtonEqual(ActionEvent event) {
        pressButtonOperator(((Button) event.getSource()).getText());
    }

    @FXML
    void pressButtonNegative(ActionEvent event) {
        if (operator == null) {
            firstValue = firstValue.charAt(0) != '-' ? "-".concat(firstValue) : firstValue.substring(1);
        } else {
            secondValue = secondValue.charAt(0) != '-' ? "-".concat(firstValue) : firstValue.substring(1);
        }
        updateScreen();
    }

    @FXML
    public void pressButtonOneOverX(ActionEvent event) {
        if (operator == null) {
            firstValue = String.valueOf((double) 1 / Double.parseDouble(firstValue));
        } else {
            secondValue = String.valueOf((double) 1 / Double.parseDouble(secondValue));
        }
        updateScreen();
    }

    @FXML
    public void pressButtonPowerOf2(ActionEvent event) {
        if (operator == null) {
            firstValue = String.valueOf(Math.pow(Double.parseDouble(firstValue), 2));
        } else {
            secondValue = String.valueOf(Math.pow(Double.parseDouble(secondValue), 2));
        }
        updateScreen();
    }

    @FXML
    public void pressButtonSqrt(ActionEvent event) {
        if (operator == null) {
            firstValue = String.valueOf(Math.sqrt(Double.parseDouble(firstValue)));
        } else {
            secondValue = String.valueOf(Math.sqrt(Double.parseDouble(secondValue)));
        }
        updateScreen();
    }
}
