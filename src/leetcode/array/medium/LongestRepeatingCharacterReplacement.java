package leetcode.array.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/longest-repeating-character-replacement/description/">Longest Repeating Character Replacement</a>
 */
public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        System.out.println("Actual: " + characterReplacement("BAAA", 0) + " Expected: 3");
        System.out.println("Actual: " + characterReplacement("AAAA", 2) + " Expected: 4");
        System.out.println("Actual: " + characterReplacement("ABCDDD", 3) + " Expected: 6");
        System.out.println("Actual: " + characterReplacement("BAAAB", 2) + " Expected: 5");
        System.out.println("Actual: " + characterReplacement("AABABBA", 1) + " Expected: 4");
    }

    public static int characterReplacement(String s, int k) {
        Map<Character, Integer> dict = new HashMap<>();
        int left = 0;
        int longest = 0;
        int mostFrequentElValue = 0;
        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);
            dict.put(current, dict.getOrDefault(current, 0) + 1);
            mostFrequentElValue = Math.max(mostFrequentElValue, dict.get(current));
            if (right - left + 1 - mostFrequentElValue > k) {
                int currentLeftCharFrequency = dict.get(s.charAt(left));
                dict.put(s.charAt(left), --currentLeftCharFrequency);
                left++;
            }
            longest = Math.max(longest, right - left + 1);
        }
        return longest;
    }

    // First attempt - failed test cases
    public static int characterReplacement2(String s, int k) {
        int maxSize = 0;
        int latestSize = 0;
        char latestLetter = ' ';
        int nextToCheckIndex = 0; // 3
        int currentIndex = 0;
        int replaced = 0;
        while (currentIndex < s.length()) {
            char currentLetter = s.charAt(currentIndex);
            if (latestSize == 0) {
                latestSize++;
                latestLetter = currentLetter;
            } else if (currentLetter == latestLetter) {
                latestSize++;
            } else {
                if (replaced == 0) {
                    nextToCheckIndex = currentIndex;
                }
                if (replaced < k) {
                    replaced++;
                    latestSize++;
                } else {
                    maxSize = Math.max(maxSize, latestSize);
                    latestLetter = s.charAt(nextToCheckIndex);
                    latestSize = 1;
                    replaced = 0;
                    currentIndex = nextToCheckIndex;
                }
            }
            currentIndex++;
        }
        if (k - replaced > 0) {
            int canReplace = Math.min(s.length() - latestSize, k - replaced);
            return Math.max(maxSize, latestSize + canReplace);
        }
        return Math.max(maxSize, latestSize);
    }
}
