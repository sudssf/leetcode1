package com.company;

import java.util.Arrays;

// at 47% how can we optimize

// learning use loop unrolling
public class zigzag {

    public static void main(String[] args) {

        String s= convert("PAYPALISHIRING", 3); // PAHNAPLSIIGYIR
        System.out.println(s);
        //PINALSIGYAHRPI 4
        s= convert("AB", 1);
        System.out.println(s);
   }

    public static String convert(String s, int numRows) {

        if(s == null || s.length() == 0){
            return "";
        }

        StringBuilder arr[] = new StringBuilder[numRows];
        for(int i=0; i< numRows; i++){
            arr[i] = new StringBuilder();
        }
        int len = s.length();
        int i=0;
        int j =0;
        boolean isUp = false;
        while(i < len){

            if(!isUp){

                if(j < numRows){
                   arr[j++].append(s.charAt(i++));
                } else {
                    isUp = true;
                    j-=2;
                    if(j < 0){
                        j =0;
                    }
                }
            } else {
                if(j >= 0){
                    arr[j--].append(s.charAt(i++));
                } else {
                    isUp = false;
                    j+=2;
                    if(j > len -1){
                        j =len -1;
                    }
                }
            }
        }

        StringBuilder ss = new StringBuilder();
        for(int k=0; k< numRows; k++){
            ss.append(arr[k]);
        }
        return ss.toString();
    }

}


/*
class Solution {
    public String convert(String s, int numRows) {
        char c[] = s.toCharArray();
        int len = c.length;
        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i=0;i<numRows;i++){
            sb[i] = new StringBuilder();
        }
        int i = 0;
        while(i < len){
            for(int idx = 0; idx < numRows && i < len; idx++){
                sb[idx].append(c[i++]);
            }
            for(int idx = numRows - 2; idx >= 1 && i < len; idx--){
                sb[idx].append(c[i++]);
            }
        }

        for(int j=1;j<numRows;j++){
            sb[0].append(sb[j]);
        }
        return sb[0].toString();
    }
}
 */