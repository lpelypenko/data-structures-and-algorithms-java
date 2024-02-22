package leetcode.array.medium;

public class SearchInRotatedSortedArray33 {
    static void runTest(int[] nums, int target, int expected) {
        runTestOriginal(nums, target, expected);
        runTestMoreCompactCode(nums, target, expected);
    }

    static void runTestOriginal(int[] nums, int target, int expected) {
        System.out.println("Input: " + nums + "(v1) Actual: " + search(nums, target) + " Expected: " + expected);
    }

    static void runTestMoreCompactCode(int[] nums, int target, int expected) {
        System.out.println("Input: " + nums + "(v2) Actual: " + searchMoreOptimalCode(nums, target) + " Expected: " + expected);
    }

    public static void main(String[] args) {
        runTest(new int[]{4, 5, 6, 7, 0, 1, 2}, 0, 4);
        runTest(new int[]{4, 5, 6, 7, 0, 1, 2}, 3, -1);
        runTest(new int[]{1}, 0, -1);
        runTest(new int[]{5, 1, 3}, 5, 0);
        runTest(new int[]{3, 1}, 1, 1);
        runTest(new int[]{5, 1, 3}, 5, 0);
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        // search for pivot index
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[nums.length - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // binary search on left part where left-1 is left to the pivot index
        int searchLeft = binarySearch(nums, target, 0, left - 1);
        if (searchLeft != -1) {
            return searchLeft;
        }
        // binary search on right part where left == pivot index
        return binarySearch(nums, target, left, nums.length - 1);
    }

    static int binarySearch(int[] nums, int target, int leftBoundary, int rightBoundary) {
        while (leftBoundary <= rightBoundary) {
            int mid = leftBoundary + (rightBoundary - leftBoundary) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                leftBoundary = mid + 1;
            } else {
                rightBoundary = mid - 1;
            }
        }
        return -1;
    }

    public static int searchMoreOptimalCode(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            System.out.println(mid);
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > target) {
                if (nums[left] > target && nums[mid] >= nums[left]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] < target) {
                if (nums[right] < target && nums[mid] <= nums[right]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return -1;
    }
}
