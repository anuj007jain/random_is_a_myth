package com.InterviewProblems;

public class Palantir_Ciphertext_Task1 {

    public static String encrypt1(String message, int shift) {

        StringBuilder str = new StringBuilder();

        for (int i = 0 ; i < message.length() ; i++) {
            int ascii_val = (int)message.charAt(i);
            //System.out.println(ascii_val);
            if (ascii_val >= 48 && ascii_val <= 57) {
                shift += ascii_val - 48;
                str.append(message.charAt(i));
                continue;
            }
            if (ascii_val >= 65 && ascii_val <= 90) {
                ascii_val = ascii_val + shift;
                while (ascii_val> 90) {
                    ascii_val -= 26;

                }
                str.append((char)(ascii_val));
                continue;
            }
            if (ascii_val >= 97 && ascii_val <= 122) {
                ascii_val = ascii_val + shift;
                while (ascii_val > 122) {
                    ascii_val -= 26;
                }
                str.append((char)(ascii_val));
                continue;
            }
            str.append(message.charAt(i));
        }
        return str.toString();
    }

    public static String encrypt(String message, int shift) {

        boolean rev = false;
        StringBuilder str = new StringBuilder();

        for (int i = 0 ; i < message.length() ; i++) {
            int ascii_val = (int)message.charAt(i);
            System.out.println(ascii_val);
            if (ascii_val == 33) {
                str.append(message.charAt(i));
                rev = !rev;
                continue;
            }
            if (ascii_val == 45) {
                str.append(message.charAt(i));
                i++;
                StringBuilder number = new StringBuilder();
                while (i < message.length() && (int)message.charAt(i) >= 48 && (int)message.charAt(i) <= 57) {
                    number.append(message.charAt(i++));
                }
                shift -= Integer.parseInt(number.toString());
                str.append(number);
                i--;
                continue;
            }
            if (ascii_val >= 48 && ascii_val <= 57) {
                StringBuilder number = new StringBuilder();
                while (i < message.length() && (int)message.charAt(i) >= 48 && (int)message.charAt(i) <= 57) {
                    number.append(message.charAt(i++));
                }
                shift += Integer.parseInt(number.toString());
                str.append(number);
                continue;
            }
            if (ascii_val >= 65 && ascii_val <= 90) {
                ascii_val = ascii_val + shift;
                while (ascii_val > 90) {
                    ascii_val -= 26;
                }
                while (ascii_val < 65) {
                    ascii_val += 26;
                }
                if (rev) {
                    if (ascii_val >= 77) {
                        ascii_val = 65 + (90 - ascii_val);
                    } else {
                        ascii_val = 90 - (ascii_val - 65);
                    }
                }
                str.append((char)(ascii_val));
                continue;
            }
            if (ascii_val >= 97 && ascii_val <= 122) {
                ascii_val = ascii_val + shift;
                while (ascii_val > 122) {
                    ascii_val -= 26;
                }
                while (ascii_val < 97) {
                    ascii_val += 26;
                }
                if (rev) {
                    if (ascii_val >= 109) {
                        ascii_val = 97 + (122 - ascii_val);
                    } else {
                        ascii_val = 122 - (ascii_val - 97);
                    }
                }
                str.append((char)(ascii_val));
                continue;
            }
            str.append(message.charAt(i));
        }
        return str.toString();
    }

    public static void main(String[] args) {
        Palantir_Ciphertext_Task1 pct1 = new Palantir_Ciphertext_Task1();
        System.out.println(pct1.encrypt(")", 4));
    }

}
