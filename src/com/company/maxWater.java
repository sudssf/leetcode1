package com.company;

// at 47% how can we optimize

// learning use loop unrolling
public class maxWater {

    public static void main(String[] args) {


        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public static int maxArea(int[] height) {
        int x = 0;
        int y = height.length - 1;

        int max = 0;
        while (y > x) {

            max = Math.max(max, (y - x) * Math.min(height[x], height[y]));
            if(height[x] > height[y]) {
                y--;
            } else {
                x++;
            }
        }

        return  max;
    }
}