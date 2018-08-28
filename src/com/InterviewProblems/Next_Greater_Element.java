package com.InterviewProblems;

import java.util.Stack;

/**
 * Created by anuj on 28/4/16.
 */
public class Next_Greater_Element {

    private void NGE(int[] arr) {
        Stack stack = new Stack();
        int[] solution = new int[arr.length];
        stack.push(arr[arr.length-1]);
        solution[arr.length-1]=-1;
        for (int i = arr.length-2; i >= 0; i--) {

                if (arr[i] < (Integer) stack.peek()) {
                    solution[i] = (Integer) stack.peek();
                    stack.push(arr[i]);
                }
                else{
                    while(!stack.empty()){
                        stack.pop();
                        if(stack.empty()) {
                            solution[i] = -1;
                            stack.push(arr[i]);
                            break;
                        }
                        if (arr[i] < (Integer) stack.peek()) {
                            solution[i] = (Integer) stack.peek();
                            stack.push(arr[i]);
                            break;
                        }
                    }

                }


        }
        for(int i=0;i<solution.length;i++)
            System.out.print(solution[i]+" ");
    }

    public static void main(String[] args) {

        Next_Greater_Element nge = new Next_Greater_Element();
        int[] arr = {0,7,2,3,5,1,6,4,2,1,4};
        nge.NGE(arr);


    }
}
