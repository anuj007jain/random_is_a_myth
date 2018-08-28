package com.LeetCode;

/**
 * Created by anuj.jain02 on 9/8/17.
 */
public class LC_006_ZigZag_Conversion {

    public String convert(String s, int numRows) {
        StringBuilder str = new StringBuilder();
        for(int row = 0 ; row < numRows; row++){
            int i = row;
            System.out.print(s.charAt(i));
            //str.append(String.valueOf(s.charAt(i)));
            boolean odd = true;
            while(true){
                //System.out.println("row: "+row+" i: "+i+" odd: "+odd);
                if(odd){
                    if(row != numRows-1){
                        i = i+2*(numRows-row-1);
                        if(i >= s.length()){
                            break;
                        }
                        System.out.print(s.charAt(i));
                    }
                    //str.append(String.valueOf(s.charAt(i)));
                    odd = false;
                }else{
                    if(row != 0){
                        i = i+2*row;
                        if(i >= s.length()){
                            break;
                        }
                        System.out.print(s.charAt(i));
                        //str.append(String.valueOf(s.charAt(i)));
                    }
                    odd = true;
                }
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        LC_006_ZigZag_Conversion lc_006_zigZag_conversion = new LC_006_ZigZag_Conversion();
        //lc_006_zigZag_conversion.convert("PAYPALISHIRINGPAYPALISHIRING",6);
        lc_006_zigZag_conversion.convert("A",1);
    }

}
