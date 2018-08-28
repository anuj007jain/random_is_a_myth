package com.InterviewProblems;

import java.util.Stack;

/**
 * Created by anuj.jain02 on 6/6/16.
 */

public class Postfix_To_Infix {

    private void PostfixToInfix(String postfix){

        Stack<String> stack = new Stack<>();
        int i = 0;
        while(i < postfix.length()){
            if((int)postfix.charAt(i) >=97 && (int)postfix.charAt(i)<=122)
                stack.push(""+postfix.charAt(i++));
            else{
                StringBuffer str = new StringBuffer();
                str.append(")");
                str.append(stack.pop());
                str.append(postfix.charAt(i++));
                str.append(stack.pop());
                str.append("(");
                stack.push(str.toString());
            }
        }
        String str = stack.pop();
        i = str.length()-1;
        while(i>=0)
            System.out.print(str.charAt(i--));
    }

    public static void main(String[] args) {

        Postfix_To_Infix pti = new Postfix_To_Infix();
        String postfix = "abc*+";
        String postfix2 = "ab+zx+*";
        pti.PostfixToInfix(postfix2);


    }

}
