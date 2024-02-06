package leetcode.array.easy;

import java.util.Arrays;

public class MergeSortedArray88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int vacant = nums1.length - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[vacant--] = nums1[p1--];
            } else {
                nums1[vacant--] = nums2[p2--];
            }
        }
        while (p2 >= 0) {
            nums1[vacant--] = nums2[p2--];
        }
        System.out.println(Arrays.toString(nums1));
    }

    // First iteration with bugs
    public static void mergeWithBugs(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0;
        int p2 = 0;
        int vacantIndex = m;
        while (p1 < nums1.length && p2 < n) {
            if (p1 >= vacantIndex) {
                nums1[vacantIndex++] = nums2[p2++];
            } else if (nums1[p1] > nums2[p2]) {
                nums1[vacantIndex++] = nums1[p1];
                nums1[p1++] = nums2[p2++];
            } else {
                p1++;
            }
        }
        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        // Failed test cases:
        // TC1: [4,0,0,0,0,0] + [1,2,3,5,6] = [1,4,2,3,5,6]
        // TC2: [2,3,4,0,0,0] + [4,5,6]
        merge(new int[]{4, 0, 0, 0, 0, 0}, 1, new int[]{1, 2, 3, 5, 6}, 5);
        merge(new int[]{2, 3, 4, 0, 0, 0}, 3, new int[]{4, 5, 6}, 3);
        merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
        merge(new int[]{1, 2, 4, 5, 6, 0}, 5, new int[]{3}, 1);
        merge(new int[]{1}, 1, new int[]{}, 0);
        merge(new int[]{0}, 0, new int[]{1}, 1);
    }
}
