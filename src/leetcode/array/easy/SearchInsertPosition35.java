package leetcode.array.easy;

public class SearchInsertPosition35 {
    public static void main(String[] args) {
        System.out.println("Insert position is: " + searchInsert(new int[]{1, 3, 5, 6}, 5) + ". Expected: 2");
        System.out.println("Insert position is: " + searchInsert(new int[]{1, 3, 5, 6}, 2) + ". Expected: 1");
        System.out.println("Insert position is: " + searchInsert(new int[]{1, 3, 5, 6}, 7) + ". Expected: 4");
    }

    /**
     * Compare to the original
     *
     * by definition left <= MAX_INT
     * by definition right <= MAX_INT
     * therefore left+right <= MAX_INT
     * and so (left+right)/2 <= MAX_INT
     */
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2; // first show why mid = (left + right) // 2
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
