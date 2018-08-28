package com.GeeksForGeeks.Array;

/**
 * Created by anuj.jain02 on 13/6/16.
 */

//http://www.geeksforgeeks.org/reverse-an-array-without-affecting-special-characters/
public class Reverse_An_Array_Without_Affecting_Special_Characters {

    private void reverseArrayWithoutAffectingSpecialCharacters(StringBuilder str){

        int flag =0;
        int i = 0;
        int j = str.length()-1;
        while(i<j){
            flag=0;
            if((int)str.charAt(i) < 65 || (int)str.charAt(i) > 122 ||  ((int)str.charAt(i) > 90 && (int)str.charAt(i) < 97))
            {
                i++;
                flag++;
            }
            if((int)str.charAt(j) < 65 || (int)str.charAt(j) > 122 ||  ((int)str.charAt(j) > 90 && (int)str.charAt(j) < 97))
            {
                j--;
                flag++;
            }
            if(flag==0) {
                swap(str, i, j);
                i++; j--;
            }



        }

    }

    private void swap(StringBuilder str, int p, int q){
        char temp = str.charAt(p);
        str.setCharAt(p, str.charAt(q));
        str.setCharAt(q,temp);
    }

    public static void main(String[] args) {

        Reverse_An_Array_Without_Affecting_Special_Characters raawasc = new Reverse_An_Array_Without_Affecting_Special_Characters();
        StringBuilder str = new StringBuilder();
        str.append("a!!!b.c.d,e'f,ghi");
        raawasc.reverseArrayWithoutAffectingSpecialCharacters(str);
        System.out.print(str);

    }

}
