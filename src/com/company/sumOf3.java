package com.company;



// learning avoid excessive comparisons at all cost
//shortcircuit when possible

import java.util.*;

/*
public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums == null || nums.length < 3) {
            return ans;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            if(nums[i] > 0) {
                break;
            }
            if(i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int start = i + 1, end = nums.length - 1, sum = 0 - nums[i];
            while(start < end) {
                if(nums[start] + nums[end] < sum) {
                    start++;
                } else if(nums[start] + nums[end] > sum) {
                    end--;
                } else {
                    ans.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    while(start < end && nums[start] == nums[start + 1]) {
                        start++;
                    }
                    while(start < end && nums[end] == nums[end - 1]) {
                        end--;
                    }
                    start++;
                    end--;
                }
            }
        }
        return ans;
    }
 */
public class sumOf3 {

    public static void main(String[] args) {


        //System.out.println(intToRoman(9996));
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum(new int[]{-2,0,1,1,2}));
        System.out.println(threeSum(new int[]{1,-1,-1,0}));
    }

    static class Sum3{
        int x;
        int y;
        int z;

        Sum3(int xx, int yy, int zz){
            x = xx;
            y = yy;
            z = zz;
        }

        @Override
        public boolean equals(Object obj) {
            Sum3 o1 = (Sum3)obj;
            if(o1.x == x && o1.y == y && o1.z == z){
                return true;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return 37* x + 41*y + 11*z;
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        HashSet<Sum3> seen = new HashSet<>();
        int sum = 0;
        for (int i = 0; i < nums.length -2 ; i++) {

            if(i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int x = nums[i];
            if( x > 0){
                break;
            }

            int j = i + 1;
            int k = nums.length -1;
            while( j < k) {
                if (i != j && k != i) {
                    int y = nums[j];
                    int z = nums[k];


                    sum =x + y + z;

                    if (sum == 0) {
                        List<Integer> r = new ArrayList<>(3);
                        r.add(x);
                        r.add(y);
                        r.add(z);
                        Collections.sort(r);
                        Sum3 s = new Sum3(r.get(0), r.get(1), r.get(2));
                        if (!seen.contains(s)) {
                            res.add(r);
                            seen.add(s);
                            while( j < k && y == nums[j+1]){
                                j++;
                            }
                            while( j < k && z == nums[k-1]){
                                k--;
                            }
                        }
                    }
                    if(sum > 0){
                        k--;
                    } else {
                        j++;
                    }


                }
            }


        }
        return res;
    }
}