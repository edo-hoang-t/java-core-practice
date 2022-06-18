package com.edocode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    private int dfs(String currentWord, Set<String> wordsPresent, Map<String, Integer> memo) {
        // base case
        if (memo.containsKey(currentWord)) return memo.get(currentWord);

        int maxLength = 1;
        StringBuilder sb = new StringBuilder(currentWord);
        for (int i = 0; i < currentWord.length(); ++i) {
            sb.deleteCharAt(i);
            String newWord = sb.toString();
            if (wordsPresent.contains(newWord)) {
                int currentLength = dfs(newWord, wordsPresent, memo) + 1;
                maxLength = Math.max(maxLength, currentLength);
            }
            // add deleted character back to its place
            sb.insert(i, currentWord.charAt(i));
        }
        // store to memo
        memo.put(currentWord, maxLength);
        return maxLength;
    }


    public int longestStrChain(String[] words) {
        Set<String> wordsPresent = new HashSet<>();
        for (String word : words) {
            wordsPresent.add(word);
        }

        Map<String, Integer> memo = new HashMap<>();
        int res = 1;
        for (String word : words) {
            res = Math.max(res, dfs(word, wordsPresent, memo));
        }

        return res;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] words = new String[] {"a","b","ba","bca","bda","bdca"};
        System.out.println(sol.longestStrChain(words));
    }
}
