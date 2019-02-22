package demo;

import utils.JsonUtils;

public class QuickSort {

    public static Integer[] sort(Integer[] array) {
        doSort(array, 0, array.length - 1);
        return array;
    }

    public static void doSort(Integer[] arr, int left, int right) {
        if (left < right) {
            Integer pivot = partition(arr, left, right);
            doSort(arr, left, pivot - 1);
            doSort(arr, pivot, right);
        }
    }

    public static Integer partition(Integer[] arr, int left, int right) {
        int mid = (left + right) / 2;
        Integer pivot = arr[mid];
        while (left <= right) {
            while (arr[left] < pivot) {
                left++;
            }
            while (arr[right] > pivot) {
                right--;
            }
            //执行到这里其实保证了arr[left] > arr[right],可以交换left和right处的值
            if (left <= right) {
                swap(arr, left, right);
                ++left;
                --right;
            }
        }
        return left;
    }

    public static void swap(Integer[] arr, int idx, int idy) {
        Integer swap = arr[idx];
        arr[idx] = arr[idy];
        arr[idy] = swap;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 3, 48, 34, 6, 8, 55, 33, 111, 346, 234, 156, 7, 66, 99, 32};
        System.out.println(JsonUtils.toJsonString(arr));
        sort(arr);
        System.out.println(JsonUtils.toJsonString(arr));
    }
}
