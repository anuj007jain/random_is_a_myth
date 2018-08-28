package com.Repeat_Practice;

/**
 * Created by anuj.jain02 on 1/9/17.
 */
public class Strings {
    public static void main(String args[]){

        //Concatenation
        String s=50+30+40+"Sachin"+40;
        System.out.println(s);//80Sachin4040

        //String pool, Heap, Intern
        String s1 = "Sachin";
        String s2 = "Sachin";
        String s3 = new String("Sachin");

        System.out.println(s1.equals(s3));
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s3.intern());

        //Stringbuffer (thread-safe) capacity, old capacity * 2 +2
        StringBuffer stringBuffer = new StringBuffer(); //default 16
        stringBuffer.append("AnujJainAnujJain"); //16
        System.out.println(stringBuffer.capacity());
        stringBuffer.append("A"); //16*2+2 = 34
        System.out.println(stringBuffer.capacity());
        stringBuffer.ensureCapacity(33);
        System.out.println(stringBuffer.capacity());
        stringBuffer.ensureCapacity(34);
        System.out.println(stringBuffer.capacity());
        stringBuffer.ensureCapacity(35);
        System.out.println(stringBuffer.capacity());

        StringBuffer stringBuffer1 = new StringBuffer(10);
        System.out.println(stringBuffer1.capacity());
        stringBuffer1.ensureCapacity(12);
        System.out.println(stringBuffer1.capacity());
        StringBuffer stringBuffer2 = new StringBuffer("Anuj");
        System.out.println(stringBuffer2.capacity());


    }
}