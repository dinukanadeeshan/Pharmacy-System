/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redonz.pms.client.others;

import javax.swing.JTextField;

/**
 *
 * @author Nadeeshan
 */
public class Validation {
    public static void validatePriceText(JTextField textField){
        String text = textField.getText();
        int caretPosition = textField.getCaretPosition();
        
        if (text.length() > 0){
            
            if(!text.matches("^[0-9]{1,}[.]?[0-9]{0,2}$")) {
                text = text.substring(0, caretPosition - 1) + text.substring(caretPosition);
                 textField.setText(text);
            }
           
        }
    }
    public static void validateBarcodeText(JTextField textField){
        String text = textField.getText();
        int caretPosition = textField.getCaretPosition();
        
        if (text.length() > 0){
            
            if(!text.matches("^[a-zA-Z0-9]+$")) {
                text = text.substring(0, caretPosition - 1) + text.substring(caretPosition);
                 textField.setText(text);
            }
           
        }
    }
    public static void validateInt(JTextField textField){
        String text = textField.getText();
        int caretPosition = textField.getCaretPosition();
        
        if (text.length() > 0){
            
            if(!text.matches("^[0-9]+$")) {
                text = text.substring(0, caretPosition - 1) + text.substring(caretPosition);
                 textField.setText(text);
            }
            
        }
    }

    public static void validateDiscountText(JTextField discountTextField) {
        String text = discountTextField.getText();
        if (!text.isEmpty()) {
            int caretPosition = discountTextField.getCaretPosition();
            if (!text.matches("^[0-9]{0,3}$") || Integer.parseInt(text) >= 100) {
                text = text.substring(0, caretPosition - 1) + text.substring(caretPosition);
                discountTextField.setText(text);
            }
        }
    }
}
