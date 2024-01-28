package leetcode.array;

public class DuplicateZeros1089 {
    public static void main(String[] args) {
        int[] tc1 = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeros(tc1);
        System.out.println(tc1);
    }

    private static void updateArray(int indexToMove, int newIndex, int[] arr) {
        if (newIndex < arr.length) {
            arr[newIndex] = arr[indexToMove];
        }
    }

    public static void duplicateZeros(int[] arr) {
        int zeroCount = 0;
        for (int element : arr) {
            if (element == 0) {
                zeroCount++;
            }
        }
        for (int index = arr.length - 1; index > 0; index--) {
            updateArray(index, index + zeroCount, arr);
            if (arr[index] == 0) {
                zeroCount--;
            }
            updateArray(index, index + zeroCount, arr);
        }
    }


    public static void duplicateZerosOld(int[] arr) {
        int zeroes = 0;
        for (int el : arr) {
            if (el == 0) {
                zeroes++;
            }
        }
        int newIndex;
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] == 0) {
                int duplicatedZeroIndex = i + zeroes;
                if (duplicatedZeroIndex <= arr.length - 1) {
                    arr[duplicatedZeroIndex] = 0;
                }
                zeroes--;
            }
            newIndex = i + zeroes;
            if (newIndex <= arr.length - 1) {
                arr[newIndex] = arr[i];
            }
        }

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0) {
                for (int j = arr.length - 1; j > i + 1; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[++i] = 0;
            }
        }
    }
}
