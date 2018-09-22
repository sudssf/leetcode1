package com.company;

import java.util.HashMap;
import java.util.Map;

// at 47% how can we optimize
public class longestSubString {

    public static void main(String[] args) {

        getresults("abcabcbb");

        getresults("abba");
//        System.out.println(lengthOfLongestSubstring("bbbbb"));
//        System.out.println(lls("bbbbb"));
//
//        System.out.println(lengthOfLongestSubstring("pwwkew"));
//        System.out.println(lls("pwwkew"));


    }

    private static void getresults(String s) {
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(lls(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {

                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
            //System.out.println("i = "+i +" put j="+j +" char "+s.charAt(j) + " = " + (j+1));
        }
        return ans;
    }


    public static int lls(String str){

        int n = str.length();

        int[] charMap = new int[255];
        int res = 0;
        for(int i=0, j=0; i< n; i++){
            int curIndex = str.charAt(i);
            if(charMap[curIndex] > 0){
                j = max(j, charMap[curIndex]);
                System.out.println(String.format("found chat %s at j = %d, i = %d", str.charAt(i), j ,i  ));
            }
            res = max(res, i -j + 1);
            charMap[curIndex] = i+1;
        }


        return res;
    }
    public static int max(int a , int b){
        return a > b ? a : b;
    }

}
