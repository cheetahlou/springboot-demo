package com.cheelou.base.xyz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author louzf
 * @decription
 * @createTime 2019/9/27 11:09
 */
public class LeetCodeSolution {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        int[] nums1 = new int[]{0,0,1,1,1,1,2,3,3};//[0,0,1,1,2,3,3]
//        removeDuplicates(nums1);
//        checkPossibility(new int[]{4,4,2,3});
//        duplicateZeros(new int[]{8,4,5,0,0,0,0,7});
        generate(5);
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
    public static void duplicateZeros(int[] arr) {
        int count = 0;
        for (int i : arr) {
            if (i == 0) count++;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (count == 0) break;
            int target = i + count; //target index
            if (target < arr.length) {
                arr[target] = arr[i];
            }
            if(arr [i] == 0){
                count--;//decrease count
                if (target - 1 < arr.length) arr[target - 1] = 0;
            }
        }
    }

    //https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
    public int findMin(int[] nums) {
        if(nums.length == 0) return -1;
        if(nums.length == 1) return nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i- 1]){
                return nums[i];
            }
        }
        return nums[0];
    }

    //binary search assume no duplicate exists in the array.
    public int findMin_BSearch(int[] nums) {
        if(nums.length == 0) return -1;
        if(nums[0] <= nums[nums.length - 1]) return nums[0];
        int left = 0,right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid+1] < nums[mid]){
                return nums[mid+1];
            }

            if(nums[mid] < nums[mid-1]){
                return nums[mid];
            }
            if(nums[left] > nums[mid]){
                //min element is in left to mid
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return nums[0];
    }
    //https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
    // binary search assume no duplicate exists in the array.
    public int findMin_2_BSearch(int[] nums) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if(nums[left] < nums[right]){
                break;
            }
            int mid = left + (right - left) / 2;
            if (nums[left] > nums[mid]) {
                //min element is in left to mid
                right = mid;
            } else if(nums[left] < nums[mid]){
                left=mid+1;
            }else{
                //nums[left] == nums[mid]
                if(nums[mid] > nums[right] ){
                    left = mid+1;
                }
                if(nums[mid] == nums[right]){
                    left++;
                    right--;
                }

            }
        }
        return nums[left];
    }

    // https://leetcode.com/problems/pascals-triangle/
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows > 0) result.add(Arrays.asList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>(i + 1);
            list.add(1);//1st and last ele = 1 in every row
            for (int j = 1; j < i; j++) {
                List<Integer> temp = result.get(i - 1);
                list.add(j, temp.get(j - 1) + temp.get(j));
            }
            list.add(1);
            result.add(list);
        }
        return result;
    }

    //https://leetcode.com/problems/pascals-triangle-ii/
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>(rowIndex);
        list.add(1); // head
        if(rowIndex > 0){

        }
        return list;
    }

    1
    1 1
    1 2 1
    1 3 3 1
    1 4 6 4 1
    1 5 10 10 5 1
    1 6 15 20 15 6 1
    1 7 21 35 35 21 7 1


}
