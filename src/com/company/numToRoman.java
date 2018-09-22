package com.company;

// at 47% how can we optimize

import java.util.HashMap;
import java.util.Map;

// learning use for-while instead

/*
public String intToRoman(int num) {

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = {"M", "CM", "D", "CD", "C", "XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < values.length; i ++){
            while(num >= values[i]){
                num -= values[i];
                sb.append(strs[i]);
            }
        }
        return sb.toString();

    }
 */
public class numToRoman {

    public static void main(String[] args) {


        //System.out.println(intToRoman(9996));
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(4));
        System.out.println(intToRoman(9));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));

    }




    public static String intToRoman(int num) {
        String romanChar[] = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D","CM","M"};
        int romanVal[] = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500,900, 1000};
        StringBuilder str = new StringBuilder();
        int i = romanVal.length - 1;
        int rem = 0;
        int div = 0;
        while (num > 0 && romanVal[i] != 1) {
            rem = num % romanVal[i];
            if (rem == num) {
                i--;
            } else {
                div = num / romanVal[i];

                num = rem;
                for (int j = 0; j < div; j++) {
                    str.append(romanChar[i]);
                }
            }
        }
        if (num > 0 && romanVal[i] == 1) {
            for (int j = 0; j < rem; j++) {
                str.append(romanChar[i]);
            }
        }

        return str.toString();

    }
}