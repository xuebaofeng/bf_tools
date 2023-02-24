package leetcode;

import java.util.*;

public class WordBreakII_140 {
    Set<String> words;
    String s;
    List<String> ans = new ArrayList();

    public static void main(String[] args) {
        WordBreakII_140 s = new WordBreakII_140();
        List<String> strings = s.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog"));
        System.out.println(strings);
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        this.words = new HashSet(wordDict);
        this.s = s;
        dfs(0, "");
        return ans;
    }

    void dfs(int start, String path) {
        if (start >= s.length()) {
            ans.add(path.trim());
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String sub = s.substring(start, i + 1);
            if (words.contains(sub)) {
                path += sub + " ";
                dfs(i + 1, path);
            }
        }
    }
}