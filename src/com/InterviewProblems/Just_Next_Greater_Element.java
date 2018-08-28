package com.InterviewProblems;

import java.util.Stack;

/**
 * Created by anuj on 28/4/16.
 */
public class Just_Next_Greater_Element {

    private void JNGE(int[] arr){
        Stack stack = new Stack();
        Stack temp = new Stack();
        int[] solution = new int[arr.length];
        stack.push(arr[arr.length-1]);
        solution[arr.length-1]=-1;
        for(int i = arr.length-2 ; i >= 0 ; i--){
            if(arr[i] < (Integer)stack.peek()){
                solution[i] = (Integer) stack.peek();
                stack.push(arr[i]);
            }
            else{
                while(!stack.empty()){
                    temp.push(stack.pop());
                    if(stack.empty()){
                        stack.push(arr[i]);
                        solution[i] = -1;
                        while(!temp.empty())
                            stack.push(temp.pop());
                        break;
                    }
                    if(arr[i] < (Integer) stack.peek()) {
                        solution[i] = (Integer) stack.peek();
                        stack.push(arr[i]);
                        while (!temp.empty())
                            stack.push(temp.pop());
                        break;
                    }
                }
            }
        }
        for(int i=0;i<solution.length;i++)
            System.out.print(solution[i]+" ");
    }

    public static void main(String[] args) {

        Just_Next_Greater_Element jnge = new Just_Next_Greater_Element();
        int[] arr = {7,2,3,6,1,5};
        jnge.JNGE(arr);


    }
}
