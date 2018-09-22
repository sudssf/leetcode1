package com.company;

// at 47% how can we optimize

// learning use char[] as str.chatAt is slow
public class longestPalindromeSubString {

    public static void main(String[] args) {

        getresults("babad");
        getresults("cbbd");
        getresults("babcbabcbaccba");
        getresults("aaaa");
//        System.out.println(lengthOfLongestSubstring("bbbbb"));
//        System.out.println(lls("bbbbb"));
//
//        System.out.println(lengthOfLongestSubstring("pwwkew"));
//        System.out.println(lls("pwwkew"));


    }

    private static void getresults(String s) {
        System.out.println(longestPalindromeSubString(s));

    }

   public static String longestPalindromeSubString(String s){
       if (s == null || s.length() < 1) return "";
       int start = 0, end = 0, avg = 0;
       for (int i = 0; i < s.length(); i++) {
           if(quickPalin(s, avg, i, i) || quickPalin(s, avg, i, i+1)) {
               int len1 = expandAroundCenter(s, i, i);
               int len2 = expandAroundCenter(s, i, i + 1);
               int len = Math.max(len1, len2);
               if (len > end - start) {
                   start = i - (len - 1) / 2;
                   end = i + len / 2;
                   avg = (end - start) / 2;
               }
           }
       }
       return s.substring(start, end + 1);
   }

    private static boolean quickPalin(String str, int avg, int left, int right) {
        if(left - avg >=0 && right + avg < str.length() && str.charAt(left) == str.charAt(right)){
            return true;
        }
        return false;
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

}
