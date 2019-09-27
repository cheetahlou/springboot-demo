package com.cheelou.base.xyz;

/**
 * @author louzf
 * @decription
 * @createTime 2019/9/27 11:09
 */
public class LeetCodeSolution {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        int[] nums1 = new int[]{0,0,1,1,1,1,2,3,3};//[0,0,1,1,2,3,3]
        removeDuplicates(nums1);
        checkPossibility(new int[]{4,4,2,3});
    }

    public int removeDuplicates1(int[] nums) {
        if (nums.length == 0) return 0;
        int dupliCount = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                dupliCount++;
            } else {
                nums[i - dupliCount] = nums[i];
            }
        }
        return nums.length - dupliCount;
    }

    //https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/submissions/
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int pdCount = 0;// partial segment duplicated count
        int j = 1; // result arr index
        if(nums.length > 1 && nums[1] == nums[0]){
            pdCount = 1;
        }
        for (int i = 2; i < nums.length; i++) {
            pdCount = (nums[j] == nums[i]) ? ++pdCount : 0;
            if (pdCount < 2) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }

    public static int removeDuplicatesZ(int[] nums) {
        if (nums.length == 0) return 0;
        int j = 1; // result arr index
        for (int i = 2; i < nums.length; i++) {
            if(nums[j-1] != nums[i]){
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }

    //https://leetcode.com/problems/non-decreasing-array/submissions/
    public static boolean checkPossibility(int[] nums) {
        int n = nums.length, count = 0;

        for (int i = 0; i + 1 < n; i++) {
            if (nums[i + 1] < nums[i]) {
                count++;
                if (i > 0 && nums[i + 1] < nums[i - 1])
                    nums[i + 1] = nums[i];
                else nums[i] = nums[i + 1];
            }
        }

        return count <= 1;
    }

    //https://leetcode.com/problems/duplicate-zeros/
    public void duplicateZeros(int[] arr) {

    }
}
