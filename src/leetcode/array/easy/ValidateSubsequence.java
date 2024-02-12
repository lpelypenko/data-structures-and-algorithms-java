package leetcode.array.easy;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ValidateSubsequence {
    public static void main(String[] args) {
        System.out.println(isValidSubsequence(Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10), Arrays.asList(1, 6, -1, 5)));
    }

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int sequencePointer = 0;
        for (Integer integer : array) {
            if (sequencePointer == sequence.size()) {
                return true;
            }
            if (Objects.equals(integer, sequence.get(sequencePointer))) {
                sequencePointer++;
            }
        }
        return sequencePointer == sequence.size();
    }
}
