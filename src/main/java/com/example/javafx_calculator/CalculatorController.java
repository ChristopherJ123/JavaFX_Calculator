package com.example.javafx_calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Objects;

public class CalculatorController {

    private String firstValue = "";
    private String secondValue = "";
    private String operator;
    private boolean isDecimal = false;

    @FXML
    private TextField calculatorTextField;

    @FXML
    void initialize() {
        calculatorTextField.setEditable(false);
    }

    void updateScreen() {
        this.calculatorTextField.setText(
                (!Objects.equals(firstValue, "") ? String.valueOf(Double.parseDouble(firstValue)) : "0") +
                        (operator != null ? " " + operator +
                                (!Objects.equals(secondValue, "") ? " " + Double.parseDouble(secondValue) : "")
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

    void pressButtonDecimal() {
        if (Objects.equals(firstValue, "")) return;
        if (operator == null) {
            if (!isDecimal) {
                firstValue = firstValue.concat(".");
                isDecimal = true;
            }
        } else {
            if (!isDecimal) {
                secondValue = secondValue.concat(".");
                isDecimal = true;
            }
        }
        updateScreen();
    }

    void pressButtonOperator(String operator) {
        if (Objects.equals(firstValue, "")) return;
        if (this.operator == null) {
            if (!operator.equals("=")) {
                this.operator = operator;
                isDecimal = false; // Reset isDecimal check for new prompts
            } else isDecimal = firstValue.contains("."); // isDecimal check for end result
        } else {
            if (Objects.equals(secondValue, "")) return;
            switch (this.operator) {
                case "+" -> firstValue = String.valueOf(Double.parseDouble(firstValue) + Double.parseDouble(secondValue));
                case "-" -> firstValue = String.valueOf(Double.parseDouble(firstValue) - Double.parseDouble(secondValue));
                case "×", "*" -> firstValue = String.valueOf(Double.parseDouble(firstValue) * Double.parseDouble(secondValue));
                case "÷", "/" -> firstValue = String.valueOf(Double.parseDouble(firstValue) / Double.parseDouble(secondValue));
            }
            if (firstValue.substring(firstValue.length()-2).equals(".0")) firstValue = firstValue.replace(".0", ""); // Check if result has a ".0" as an ending and remove it so that you can input normally.
            this.operator = null;
            secondValue = "";
            pressButtonOperator(operator);
        }
        updateScreen();
    }

    void pressButtonBackslash() {
        if (operator == null) {
            try {
                firstValue = firstValue.substring(0, firstValue.length()-1);
            } catch (Exception ignored) {}
        } else {
            try {
                secondValue = secondValue.substring(0, secondValue.length()-1);
            } catch (Exception ignored) {}
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
        pressButtonDecimal();
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
        if (Objects.equals(firstValue, "")) return;
        if (operator == null) {
            firstValue = firstValue.charAt(0) != '-' ? "-".concat(firstValue) : firstValue.substring(1);
        } else {
            secondValue = secondValue.charAt(0) != '-' ? "-".concat(firstValue) : firstValue.substring(1);
        }
        updateScreen();
    }

    @FXML
    public void pressButtonOneOverX(ActionEvent event) {
        if (Objects.equals(firstValue, "")) return;
        if (operator == null) {
            firstValue = String.valueOf((double) 1 / Double.parseDouble(firstValue));
        } else {
            secondValue = String.valueOf((double) 1 / Double.parseDouble(secondValue));
        }
        updateScreen();
    }

    @FXML
    public void pressButtonPowerOf2(ActionEvent event) {
        if (Objects.equals(firstValue, "")) return;
        if (operator == null) {
            firstValue = String.valueOf(Math.pow(Double.parseDouble(firstValue), 2));
        } else {
            secondValue = String.valueOf(Math.pow(Double.parseDouble(secondValue), 2));
        }
        updateScreen();
    }

    @FXML
    public void pressButtonSqrt(ActionEvent event) {
        if (Objects.equals(firstValue, "")) return;
        if (operator == null) {
            firstValue = String.valueOf(Math.sqrt(Double.parseDouble(firstValue)));
        } else {
            secondValue = String.valueOf(Math.sqrt(Double.parseDouble(secondValue)));
        }
        updateScreen();
    }

    @FXML
    public void calculatorKeyListener(KeyEvent event) {
        String input = event.getText();
        if (event.isShiftDown()) {
            if (input.matches("[8=]")) {
                if (input.equals("8")) pressButtonOperator("*");
                else if (input.equals("=")) pressButtonOperator("+");
            }
        } else if (input.matches("[0-9]")) {
            pressButtonNumber(input);
        } else if (input.matches("[+\\-*/=]")) {
            pressButtonOperator(input);
        } else if (input.equals(".")) {
            pressButtonDecimal();
        } else if (event.getCode() == KeyCode.BACK_SPACE) {
            pressButtonBackslash();
        } else if (event.getCode() == KeyCode.ENTER) {
            pressButtonOperator("=");
        }
    }
}
