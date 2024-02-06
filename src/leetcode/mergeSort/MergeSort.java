package leetcode.mergeSort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeSort(new int[]{2, 8, 10, 4, 1})));
    }

    public static int[] mergeTwoArrays(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        int r = 0;
        int p1 = 0;
        int p2 = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] > nums2[p2]) {
                result[r++] = nums2[p2++];
            } else {
                result[r++] = nums1[p1++];
            }
        }
        while (p1 < nums1.length) {
            result[r++] = nums1[p1++];
        }
        while (p2 < nums2.length) {
            result[r++] = nums2[p2++];
        }
        return result;
    }

    public static int[] mergeSort(int[] array) {
        // base case: array with 1 element is by definition sorted
        if (array.length == 1) return array;
        int midIndex = array.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(array, 0, midIndex));
        int[] right = mergeSort(Arrays.copyOfRange(array, midIndex, array.length));

        return mergeTwoArrays(left, right);
    }
}
