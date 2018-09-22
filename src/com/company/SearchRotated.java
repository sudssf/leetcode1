package com.company;

/*
best 7ms
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;

        int pivot = nums[end];
        while (start < end - 1) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                if (target > pivot && nums[mid] <= pivot) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (nums[mid] > pivot && target <= pivot) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }

        if (nums[start] == target) return start;
        if (nums[end] == target) return end;
        return -1;
 */
public class SearchRotated {

    public static void main(String args []) {

        int arr[] = new int[] {4,5,6,7,0,1,2};
        SearchRotated sr = new SearchRotated();

        System.out.println(sr.search(arr, 0));
        arr = new int[] {1,3,5};

        System.out.println(sr.search2(arr, 1));

    }


    public int search(int[] nums, int target) {

        int low =  0;
        int high = nums.length - 1;
        int mid = low;
        while( low <= high) {

            mid = (low + high) / 2;

            if(nums[mid] == target) {
                return mid;
            }
            if(nums[low] == target) {
                return low;
            }
            if(nums[high] == target) {
                return high;
            }


            if(nums[mid] >= nums[low]) {
                if(target < nums[mid] && target > nums[low]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if(target > nums[mid] && target < nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }


        }

        return -1;
    }

    public int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        int mid = low;
        while (low < high - 1) {

            mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[low]) {
                if (target < nums[mid] && target >= nums[low]) {
                    high = mid;
                } else {
                    low = mid;
                }
            } else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid;
                } else {
                    high = mid;
                }
            }


        }

        if (nums[low] == target) {
            return low;
        }
        if (nums[high] == target) {
            return high;
        }

        return -1;
    }
}
