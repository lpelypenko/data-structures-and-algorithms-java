package leetcode.array.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int left = 0; // 1
        int maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            char letter = s.charAt(right);
            if (seen.contains(letter)) {
                maxLength = Math.max(maxLength, seen.size());
                while (seen.contains(letter)) {
                    seen.remove(s.charAt(left++));
                }
                seen.add(letter);
            } else {
                seen.add(letter);
            }
        }
        return Math.max(maxLength, seen.size());
    }
}
