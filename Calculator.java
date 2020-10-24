/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;
import java.util.Stack;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

/** 
 *
 * @Nisser Aldossary
 */
public class Calculator {
    
    Map<String,Integer> priorityMap;
    
    public Calculator(){
        priorityMap = new HashMap<>();
        priorityMap.put("*", 3);
        priorityMap.put("/", 3);
        priorityMap.put("+", 2);
        priorityMap.put("-", 2);
        priorityMap.put("^", 2);
    }
    
    public String Finalcalculate(String input){
        String[] postFixInput = parseUserInput(input);
        String outcome = evaluateOfPostFix(postFixInput);
        return outcome;
    }
    
    //implementation of the shunting-yard algorithm to transform string to postfix notation
    private String[] parseUserInput(String input){
        List<String> postFix;
        postFix = new ArrayList<>();
        String[] tokenizInput;
        tokenizInput = tokeInput(input);
        Stack<String> operStack = new Stack();
        
        for(String myToken : tokenizInput){
            if(myToken.matches("\\-?\\d+")){ //if myToken is a number, append to output string
                postFix.add(myToken);
            }
            else if(myToken.matches("[\\+\\-\\/\\*\\^]")){ //This will tell if myToken is operator" there is "oper" on the top of the stack and it's a bigger priority. 
                //OR, has equal priority and oper left linked. OR, it's not left "(".
                while(leftParenthesisCheck(operStack) && checkForPriority(myToken, operStack)){ 
                    postFix.add(operStack.pop()); //pop the operators from the stack to the outcome queue.
                }
                operStack.push(myToken); //push operator to oper stack.
            }
            else if(myToken.matches("\\(")){ //if token is )
                operStack.push(myToken); //push ) to operator stack
            }
            else if(myToken.matches("\\)")){ //if token (
                while(leftParenthesisCheck(operStack)){ //the operator is not a )
                    postFix.add(operStack.pop()); //pop the operators from the stack to the outcome queue.
                }
                if(operStack.empty()){
                    throw new RuntimeException("Invalid, unmatching parentheses!");//error if stack empty
                }else{ //if it don't get to the end of stack
                    operStack.pop(); //pop ) 
                }
            }
        }
        
        while(!operStack.empty()){
            if(operStack.peek().equals("(") || operStack.peek().equals(")")){
                throw new RuntimeException("There were mismatched parentheses in your operation! This is illegal!");//MISMATCHED PARENTHESES LEFT ON STACK - ERROR
            }else{
                postFix.add(operStack.pop());
            }
        }
        
        return postFix.toArray(new String[0]);
    }
     
    private String[] tokeInput(String inputnum){
        List<String> tokList = new ArrayList<>();
        String[] tokenInput = inputnum.split("");
        StringBuilder currentnum = new StringBuilder();
        
        for(String tok : tokenInput){
            if(!tok.matches("\\d")){ if(tok.matches("[\\+\\-\\/\\*\\^\\(\\)]")){
                if(currentnum.length() > 0){
                    tokList.add(currentnum.toString());
                    currentnum = new StringBuilder(); //the new StringBuilder delete the past number that was stored
                }
                tokList.add(tok);
            }
            }
            else {
                //theToken = number, put in output string
                currentnum.append(tok);
            }
        }
        if(currentnum.length() <= 0){
        } else {
            tokList.add(currentnum.toString());
        }
        
        return tokList.toArray(new String[0]);
    }
    
    private boolean checkForPriority(String runningOper, Stack<String> operatorStack){//This will check if the stack is not empty, and if the token is >= priority to the top oper.
        boolean priorityResult = false;
        if(!operatorStack.empty() && priorityMap.get(operatorStack.peek()) >= priorityMap.get(runningOper)){
            priorityResult = true;
        }//runningOperatorer

        return priorityResult;
    }
    
    private boolean leftParenthesisCheck(Stack<String> operatorStack){//checking for empty stack, and left parenthesis is not on top of the stack
        boolean operResult = false;
        if(operatorStack.empty() || operatorStack.peek().equals("(")){
        } else {
            operResult = true;
        }
        return operResult;
    }
    
    private String evaluateOfPostFix(String[] equationOfPostFix){ //The evaluate of postfix
        Stack<String> evaluateStack = new Stack();
        String outcome = "";
                
        for(String token : equationOfPostFix){
            if(!token.matches("[\\+\\-\\/\\*\\^]")){
                if(token.matches("\\-?\\d+")){
                    evaluateStack.push(token);
                }
            }
            else {
                if(evaluateStack.size() < 2){
                    throw new RuntimeException("Invalid equation, there are unaccepted operators!");
                }else{
                    String value1, value2;
                     value2 = evaluateStack.pop();
                     value1 = evaluateStack.pop();
                    evaluateStack.push(evaluateOperation(value1, value2, token));
                }
            }
        }
        if(evaluateStack.empty()){
            throw new RuntimeException("ERROR happened during the calculation!");
        }else{
            outcome = evaluateStack.pop();
        }
        
        return outcome;
    }
    
    private String evaluateOperation(String value1, String value2, String operator){
        String outcome = "";
        
        if(!value1.matches("\\-?\\d+") || !value2.matches("\\-?\\d+")){
            throw new RuntimeException("Incorrect inputs, please check your equation again!");
        }else{ //This will check if the values are numbers
            switch(operator){
                case "+": outcome = Addition(value1, value2);
                break;
                case "-": outcome = Subtraction(value1, value2);
                break;
                case "^": outcome = Power(value1, value2);
                break;
                //case "sin": outcome = Sin(value1);
                //break;
                case "*": outcome = Multiplication(value1, value2);
                break;
                case "/": outcome = Division(value1, value2);
                break;
                default: throw new RuntimeException("Invalid input, only +, -, *, /,^ are accepted.");
            }
        }
        return outcome;
    }
    
    private String Addition(String value1, String value2){
        String outcome = "";
        int val1, val2, valOutcome;
        val1 = Integer.parseInt(value1);
        val2 = Integer.parseInt(value2);
        valOutcome = val1+val2;
        outcome = Integer.toString(valOutcome);
        return outcome;
    }
    private String Multiplication(String value1, String value2){
        String outcome = "";
        int val1, val2, valOutcome;
        val1 = Integer.parseInt(value1);
        val2 = Integer.parseInt(value2);
        valOutcome = val1*val2;
        outcome = Integer.toString(valOutcome);
        return outcome;
    }
    private String Subtraction(String value1, String value2){
        String outcome = "";
        int val1, val2, valOutcome;
        val1 = Integer.parseInt(value1);
        val2 = Integer.parseInt(value2);
        valOutcome = val1-val2;
        outcome = Integer.toString(valOutcome);
        return outcome;
    }
    private String Division(String value1, String value2){
        String outcome = "";
        double val1, val2, valOutcome;
        val1 = Double.parseDouble(value1);
        val2 = Double.parseDouble(value2);
        valOutcome = val1/val2;
        outcome = Double.toString(valOutcome);
        return outcome;
    }
    private String Power(String value1, String value2){
        String outcome = "";
        double val1, val2, valOutcome;
        val1 = Double.parseDouble(value1);
        val2 = Double.parseDouble(value2);
        valOutcome = Math.pow(val1, val2);
        outcome = Double.toString(valOutcome);
        return outcome;
    }
    private String Sin(String value1){
        String outcome = "";
        double val1, valOutcome;
        val1 = Double.parseDouble(value1);
        //val2 = Double.parseDouble(value2);
        valOutcome = Math.sin(val1);
        outcome = Double.toString(valOutcome);
        return outcome;
    }
    private String Cos(String value1){
        String outcome = "";
        double val1, valOutcome;
        val1 = Double.parseDouble(value1);
        //val2 = Double.parseDouble(value2);
        valOutcome = Math.cos(val1);
        outcome = Double.toString(valOutcome);
        return outcome;
    }
    private String Log(String value1){
        String outcome = "";
        double val1, valOutcome;
        val1 = Double.parseDouble(value1);
        //val2 = Double.parseDouble(value2);
        valOutcome = Math.log(val1);
        outcome = Double.toString(valOutcome);
        return outcome;
    }
    
    
}