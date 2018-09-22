package com.company;

// at 47% how can we optimize

import org.omg.PortableInterceptor.INACTIVE;

// learning use loop unrolling
public class atoi {

    public static void main(String[] args) {

        String strArr[] = new String[]{"42", "-42", "4193 with words", "words and 987", "-91283472332", "+", "+-2", "2147483648"};
        for (int i = 0; i < strArr.length; i++) {
            Long s = myAtoi(strArr[i]);
            System.out.println(s);
        }


    }

    public static long myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int n = str.length();
        char chars[] = str.toCharArray();
        long res = 0;
        boolean res1 = false;

        int i =0;
        while(i < n && chars[i] == ' '){
            i++;
        }
        if(i < n && chars[i] == '+'){
            i++;
        } else if(i < n && chars[i] == '-'){
            res1 = true;
            i++;
        }
        for (; i < n; i++) {
            if(chars[i] >= '0' && chars[i] <= '9'){
                //res = ((res << 3) + res + res) + (chars[i] - '0');
                res = res *10 + (chars[i] - '0');
                if(res > Integer.MAX_VALUE ){
                    return !res1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
            } else {
                break;
            }
        }
        if(res1){
            res *= -1;
        }
        return ((int)res);
    }
}

