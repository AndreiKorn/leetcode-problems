package com.korn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {
    private final Map<String, Boolean> results = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.isEmpty()) {
            return true;
        }

        if (results.containsKey(s)) {
            return results.get(s);
        }

        for (String word : wordDict) {
            int wordIndex = s.indexOf(word);
            if (wordIndex >= 0
                    && wordBreak(s.substring(0, wordIndex), wordDict)
                    && wordBreak(s.substring(wordIndex + word.length()), wordDict)
            ) {
                results.put(s, true);
                return true;
            }
        }

        results.put(s, false);
        return false;
    }
}
