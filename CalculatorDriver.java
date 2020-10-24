/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;
import javax.swing.JFrame;

/**
 *
 * @Nisser Aldossary
 */
public class CalculatorDriver {

public static void main(String[] args) {
        JFrame mainFrame = new CalculatorFrame();
        mainFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setSize(new java.awt.Dimension(490, 490));
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }
    
}
