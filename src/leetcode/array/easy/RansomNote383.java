package leetcode.array.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/ransom-note/description/
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 *
 * Each letter in magazine can only be used once in ransomNote.
 *
 *
 *
 * Example 1:
 *
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * Example 2:
 *
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * Example 3:
 *
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote and magazine consist of lowercase English letters.
 */
public class RansomNote383 {
    public static void main(String[] args) {

    }

    /**
     Third solution: 12:14 -- 12:19
     Space complexity O(m) where m length of magazine string
     Time complexity O(n) where n is length of ransomNote string
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        Map<Character, Integer> magazineCounter = new HashMap<>();
        for (char letter: magazine.toCharArray()) {
            int counter = magazineCounter.getOrDefault(letter, 0);
            magazineCounter.put(letter, ++counter);
        }
        for (char letter: ransomNote.toCharArray()) {
            if (!magazineCounter.containsKey(letter) || magazineCounter.get(letter) == 0) {
                return false;
            } else {
                int counter = magazineCounter.get(letter);
                magazineCounter.put(letter, --counter);
            }
        }

        return true;
    }

    /**
     Second solution: 11:57 -- 12:05
     Space complexity O(n) where n length of ransomNote
     Time complexity O(m) where m is length of magazine string
     */
    public boolean canConstruct2(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        Map<Character, Integer> ransomCounter = new HashMap<>();
        for (int i = 0; i < ransomNote.length(); i++) {
            int currentVal = ransomCounter.getOrDefault(ransomNote.charAt(i), 0);
            ransomCounter.put(ransomNote.charAt(i), ++currentVal);
        }
        for (int i = 0; i < magazine.length(); i++) {
            char currentVal = magazine.charAt(i);
            if (ransomCounter.containsKey(currentVal)) {
                int newRansomNoteFreq = ransomCounter.get(currentVal) - 1;
                if (newRansomNoteFreq == 0) {
                    ransomCounter.remove(currentVal);
                    if (ransomCounter.isEmpty()) {
                        return true;
                    }
                } else {
                    ransomCounter.put(currentVal, newRansomNoteFreq);
                }
            }
        }

        return ransomCounter.isEmpty();
    }

    /**
     First solution: 11:40 -- 11:54
     Space complexity O(n + m) where n length of ransomNote and m length of magazine
     Time complexity O(x) where x is the longest between ransomNote and magazine
     */
    public boolean canConstructFirst(String ransomNote, String magazine) {
        Map<Character, Integer> magazineFreq = new HashMap<>(); // {a: 2, b: 1}
        for (int i = 0; i < magazine.length(); i++) {
            int currentVal = magazineFreq.getOrDefault(magazine.charAt(i), 0);
            magazineFreq.put(magazine.charAt(i), ++currentVal);
        }
        Map<Character, Integer> ransomFreq = new HashMap<>(); // {a: 2}
        for (int i = 0; i < ransomNote.length(); i++) {
            int currentVal = ransomFreq.getOrDefault(ransomNote.charAt(i), 0);
            ransomFreq.put(ransomNote.charAt(i), ++currentVal);
        }
        for (Map.Entry<Character, Integer> ransom : ransomFreq.entrySet()) {
            if (!magazineFreq.containsKey(ransom.getKey()) || ransom.getValue() > magazineFreq.get(ransom.getKey())) {
                return false;
            }
        }
        return true;
    }
}
