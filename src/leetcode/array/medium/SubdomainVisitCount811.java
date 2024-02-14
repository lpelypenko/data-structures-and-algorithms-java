package leetcode.array.medium;

import java.util.*;

public class SubdomainVisitCount811 {
    public static void main(String[] args) {
        System.out.println(subdomainVisits(new String[]{"9001 discuss.leetcode.com"}));
        System.out.println(subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
    }

    /**
     * 17:54 - 18:24 including complexity analysis
     "n" - cpdomain.length
     "k" - an average length of a domain (cpdomain[i].length)
     "s" average count of subdomains (e.g s=3 in discuss.leetcode.com)
     Space complexity: O(n * s)
     Time complexity: O(n * k)
     */
    public static List<String> subdomainVisits(String[] cpdomains) {
        // ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
        // HashMap:
        // "google.mail.com" : 900
        // "mail.com" : 900 + 1
        // "com" : 900 + 50 + 1
        // "yahoo.com": 50
        // "intel.mail.com": 1
        // "wiki.org": 5
        // "org": 5
        Map<String, Integer> map = new HashMap<>();
        for (String domainCP: cpdomains) {
            String[] countPair = domainCP.split(" ");
            Integer freq = Integer.parseInt(countPair[0]);
            map.put(countPair[1], map.getOrDefault(countPair[1], 0) + freq);
            String[] domainParts = countPair[1].split("\\.");
            String temp = null;
            for (int i = domainParts.length - 1; i > 0; i--) {
                if (temp != null) {
                    temp = domainParts[i] + "." + temp;
                } else {
                    temp = domainParts[i];
                }
                map.put(temp, map.getOrDefault(temp, 0) + freq);
            }
        }
        List<String> res = new LinkedList<>();

        for (Map.Entry<String, Integer> pair: map.entrySet()) {
            res.add(pair.getValue()  + " " + pair.getKey());
        }

        return res;
    }
}
