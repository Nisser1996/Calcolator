/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;
import javax.swing.JOptionPane;

/**
 *
 * @author Nisser Aldossary
 */
public class CalculatorFrame extends javax.swing.JFrame {

    private final Calculator TheCalculator;
    private StringBuilder dispString;//display The String
    private int numberLeftParenthesis; 
    
    public CalculatorFrame() {
        TheCalculator = new Calculator();
        dispString = new StringBuilder();
        numberLeftParenthesis = 0;//number Left Parenthesis
        initComponents();
    }

    //Number button handler
    private void numberButtHandler(String number){
        dispString.append(number);
        updateTheDisplay();
    }
    
    private void ParenthesisHandler(String paren){
        if(!paren.equals("(")){
            if(paren.equals(")")){
                if(numberLeftParenthesis > 0){
                    numberLeftParenthesis--;
                    dispString.append(paren);
                }
            }
        }
        else {
            numberLeftParenthesis++;
            dispString.append(paren);
        }
        updateTheDisplay();
    }
    
    //operator handle the buttons
    private void ButtHandler(String operator){
        switch(operator){//Button Handler
            case "+": 
            case "-": 
            case "*": 
            case "^":
            case "/": 
                if(checkOperStatus()){
                    dispString.append(operator);
                    updateTheDisplay();
                }
            break;
            
            case "=":
                theEualsHandler();
            break;
            
            case "C": 
                resetCalculator();
                updateTheDisplay();
            break;
            default: throw new RuntimeException("You Did Break the Calculator!");
        }
    }
    
    private void updateTheDisplay(){
        if(dispString.length() <= 0){
            displayFunctionLabel.setText("0");
        }else{
            displayFunctionLabel.setText(dispString.toString());
        }
    }
    
    //If it's all fine to add new operator to the string it will return true
    //it's fine now to add new operator since it display string longer than 0.
    // Or if the last char is number of closing parentheses
    private boolean checkOperStatus(){
        boolean safeOperator = false;
        
        if(dispString.length() > 0 && Character.toString(dispString.charAt(dispString.length()-1)).matches("[0-9)]")){
            safeOperator = true;
        }
        
        return safeOperator;
    }
    
    private void resetCalculator(){
        dispString = new StringBuilder();
        numberLeftParenthesis = 0;
    }
    
    private void theEualsHandler(){//if there is valid inputs do the calculation, if not nothing will happen
        if(checkOperStatus() && (numberLeftParenthesis == 0)){
            try{
                String outcome = TheCalculator.Finalcalculate(dispString.toString());
                resetCalculator();
                dispString.append(outcome);
                updateTheDisplay();
            }
            catch(Exception x){
                JOptionPane.showMessageDialog(null, x.getMessage());
                resetCalculator();
                updateTheDisplay();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Invalid calculation, close parentheses, and don't end the calculation with operator!!");
        }
    }
    
    
    //This method is called in the constructor to set the form.
    @SuppressWarnings("unchecked")
    private void initComponents() {

        displayFunctionLabel = new javax.swing.JLabel();
        buttonPanel = new javax.swing.JPanel();
        powerButton = new javax.swing.JButton();
        sevenButton = new javax.swing.JButton();
        sinButton = new javax.swing.JButton();
        eightButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        nineButton = new javax.swing.JButton();
        equalsButton = new javax.swing.JButton();
        divButton = new javax.swing.JButton();
        fourButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton(); 
        fiveButton = new javax.swing.JButton();
        rightParenButton = new javax.swing.JButton();
        sixButton = new javax.swing.JButton();
        multButton = new javax.swing.JButton();
        zeroButton = new javax.swing.JButton();
        oneButton = new javax.swing.JButton();
        leftParenButton = new javax.swing.JButton();
        twoButton = new javax.swing.JButton();
        subButton = new javax.swing.JButton();
        threeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(490, 550));
        setSize(new java.awt.Dimension(490, 550));

        buttonPanel.setPreferredSize(new java.awt.Dimension(488, 400));
        buttonPanel.setLayout(new java.awt.GridLayout(5, 4, 1, 1));

        sevenButton.setFont(new java.awt.Font("Dialog", 1, 18)); 
        sevenButton.setText("7");
        sevenButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sevenButtonMouseClicked(evt);
            }
        });
        buttonPanel.add(sevenButton);

        eightButton.setFont(new java.awt.Font("Dialog", 1, 18)); 
        eightButton.setText("8");
        eightButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eightButtonMouseClicked(evt);
            }
        });
        buttonPanel.add(eightButton);

        nineButton.setFont(new java.awt.Font("Dialog", 1, 18)); 
        nineButton.setText("9");
        nineButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nineButtonMouseClicked(evt);
            }
        });
        buttonPanel.add(nineButton);

        divButton.setFont(new java.awt.Font("Dialog", 1, 18)); 
        divButton.setText("/");
        divButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                divButtonMouseClicked(evt);
            }
        });
        buttonPanel.add(divButton);

        fourButton.setFont(new java.awt.Font("Dialog", 1, 18)); 
        fourButton.setText("4");
        fourButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fourButtonMouseClicked(evt);
            }
        });
        buttonPanel.add(fourButton);

        fiveButton.setFont(new java.awt.Font("Dialog", 1, 18)); 
        fiveButton.setText("5");
        fiveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fiveButtonMouseClicked(evt);
            }
        });
        buttonPanel.add(fiveButton);

        sixButton.setFont(new java.awt.Font("Dialog", 1, 18)); 
        sixButton.setText("6");
        sixButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sixButtonMouseClicked(evt);
            }
        });
        buttonPanel.add(sixButton);

        multButton.setFont(new java.awt.Font("Dialog", 1, 18)); 
        multButton.setText("*");
        multButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                multButtonMouseClicked(evt);
            }
        });
        buttonPanel.add(multButton);

        oneButton.setFont(new java.awt.Font("Dialog", 1, 18)); 
        oneButton.setText("1");
        oneButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                oneButtonMouseClicked(evt);
            }
        });
        buttonPanel.add(oneButton);

        twoButton.setFont(new java.awt.Font("Dialog", 1, 18)); 
        twoButton.setText("2");
        twoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                twoButtonMouseClicked(evt);
            }
        });
        buttonPanel.add(twoButton);

        threeButton.setFont(new java.awt.Font("Dialog", 1, 18)); 
        threeButton.setText("3");
        threeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                threeButtonMouseClicked(evt);
            }
        });
        buttonPanel.add(threeButton);

        subButton.setFont(new java.awt.Font("Dialog", 1, 18)); 
        subButton.setText("-");
        subButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                subButtonMouseClicked(evt);
            }
        });
        buttonPanel.add(subButton);

        leftParenButton.setFont(new java.awt.Font("Dialog", 1, 18)); 
        leftParenButton.setText("(");
        leftParenButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                leftParenButtonMouseClicked(evt);
            }
        });
        buttonPanel.add(leftParenButton);

        zeroButton.setFont(new java.awt.Font("Dialog", 1, 18)); 
        zeroButton.setText("0");
        zeroButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                zeroButtonMouseClicked(evt);
            }
        });
        buttonPanel.add(zeroButton);

        rightParenButton.setFont(new java.awt.Font("Dialog", 1, 18)); 
        rightParenButton.setText(")");
        rightParenButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rightParenButtonMouseClicked(evt);
            }
        });
        buttonPanel.add(rightParenButton);

        addButton.setFont(new java.awt.Font("Dialog", 1, 18)); 
        addButton.setText("+");
        addButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addButtonMouseClicked(evt);
            }
        });
        buttonPanel.add(addButton);

        equalsButton.setFont(new java.awt.Font("Dialog", 1, 18)); 
        equalsButton.setText("=");
        equalsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                equalsButtonMouseClicked(evt);
            }
        });
        buttonPanel.add(equalsButton);

        clearButton.setFont(new java.awt.Font("Dialog", 1, 18)); 
        clearButton.setText("Clear");
        clearButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearButtonMouseClicked(evt);
            }
        });
        buttonPanel.add(clearButton);

        sinButton.setFont(new java.awt.Font("Dialog", 1, 18)); 
        sinButton.setText("sin");
        sinButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sinButtonMouseClicked(evt);
            }
        });
        buttonPanel.add(sinButton);
        powerButton.setFont(new java.awt.Font("Dialog", 1, 18)); 
        powerButton.setText("^");
        powerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                powerButtonMouseClicked(evt);
            }
        });
        buttonPanel.add(powerButton);

        displayFunctionLabel.setFont(new java.awt.Font("Dialog", 1, 24)); 
        displayFunctionLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        displayFunctionLabel.setText("0");
        displayFunctionLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 0, 0)));
        displayFunctionLabel.setMaximumSize(new java.awt.Dimension(396, 74));
        displayFunctionLabel.setPreferredSize(new java.awt.Dimension(396, 74));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(displayFunctionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(displayFunctionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
    }

    private void zeroButtonMouseClicked(java.awt.event.MouseEvent evt) {
        numberButtHandler("0");
    }
    private void sevenButtonMouseClicked(java.awt.event.MouseEvent evt) {
        numberButtHandler("7");
    }
    private void eightButtonMouseClicked(java.awt.event.MouseEvent evt) {
        numberButtHandler("8");
    }
    private void nineButtonMouseClicked(java.awt.event.MouseEvent evt) {
        numberButtHandler("9");
    }
    private void fourButtonMouseClicked(java.awt.event.MouseEvent evt) {
        numberButtHandler("4");
    }
    private void fiveButtonMouseClicked(java.awt.event.MouseEvent evt) {
        numberButtHandler("5");
    }
    private void sixButtonMouseClicked(java.awt.event.MouseEvent evt) {
        numberButtHandler("6");
    }
    private void oneButtonMouseClicked(java.awt.event.MouseEvent evt) {
        numberButtHandler("1");
    }
    private void twoButtonMouseClicked(java.awt.event.MouseEvent evt) {
        numberButtHandler("2");
    }
    private void threeButtonMouseClicked(java.awt.event.MouseEvent evt) {
        numberButtHandler("3");
    }
    private void leftParenButtonMouseClicked(java.awt.event.MouseEvent evt) {
        ParenthesisHandler("(");
    }
    private void rightParenButtonMouseClicked(java.awt.event.MouseEvent evt) {
        ParenthesisHandler(")");
    }
    private void divButtonMouseClicked(java.awt.event.MouseEvent evt) {
        ButtHandler("/");
    }
    private void powerButtonMouseClicked(java.awt.event.MouseEvent evt) {
        ButtHandler("^");
    }
    private void multButtonMouseClicked(java.awt.event.MouseEvent evt) {
        ButtHandler("*");
    }
    private void subButtonMouseClicked(java.awt.event.MouseEvent evt) {
        ButtHandler("-");
    }
    private void addButtonMouseClicked(java.awt.event.MouseEvent evt) {
        ButtHandler("+");
    }
    private void equalsButtonMouseClicked(java.awt.event.MouseEvent evt) {
        ButtHandler("=");
    }
    private void clearButtonMouseClicked(java.awt.event.MouseEvent evt) {
        ButtHandler("C");
    }
    private void sinButtonMouseClicked(java.awt.event.MouseEvent evt) {
        ButtHandler("sin");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CalculatorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        // display form
        java.awt.EventQueue.invokeLater(() -> {
            new CalculatorFrame().setVisible(true);
        });
    }
    
    //declar variables
    private javax.swing.JButton addButton,divButton,eightButton,equalsButton,fiveButton,
            fourButton, leftParenButton,multButton,nineButton,oneButton,rightParenButton, powerButton,
            sevenButton,sixButton,subButton,threeButton,twoButton,zeroButton,sinButton,clearButton;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JLabel displayFunctionLabel;
}