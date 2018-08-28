package com.InterviewProblems;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by anuj.jain02 on 13/5/17.
 */
public class Yatra_Braces {

    public static void main(String[] args) {
        String[] values = new String[3];
        String[] result = new String[values.length];
        values[0] = "{}[]()";
        values[1] = "{[}]}";
        values[2] = "";

        int count = 0;

        for(String value : values){
            boolean flag = true;
            Stack stack = new Stack();
            for(int i = 0 ; i < value.length() ; i++){
                if(value.charAt(i) == '{'){
                    stack.push('{');
                }
                else if(value.charAt(i) == '('){
                    stack.push('(');
                }
                else if(value.charAt(i) == '['){
                    stack.push('[');
                }
                else if(value.charAt(i) == '}'){
                    if(stack.empty()){
                        result[count++] = "NO";
                        flag = false;
                        break;
                    }
                    if((Character)stack.peek() == '{'){
                        stack.pop();
                    }
                    else{
                        result[count++] = "NO";
                        flag = false;
                        break;
                    }
                }
                else if(value.charAt(i) == ')'){
                    if(stack.empty()){
                        result[count++] = "NO";
                        flag = false;
                        break;
                    }
                    if((Character)stack.peek() == '('){
                        stack.pop();
                    }
                    else{
                        result[count++] = "NO";
                        flag = false;
                        break;
                    }
                }
                else if(value.charAt(i) == ']'){
                    if(stack.empty()){
                        result[count++] = "NO";
                        flag = false;
                        break;
                    }
                    if((Character)stack.peek() == '['){
                        stack.pop();
                    }
                    else{
                        result[count++] = "NO";
                        flag = false;
                        break;
                    }
                }
                else {
                    result[count++] = "NO";
                    flag = false;
                    break;
                }
            }
            if(flag){
                result[count++] = "YES";
            }
        }
        System.out.print(Arrays.toString(result));
    }

}
