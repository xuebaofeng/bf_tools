package leetcode;

public class DecodeWays91 {
    public static void main(String[] args) {
        DecodeWays91 s = new DecodeWays91();
        s.numDecodings("27");
    }

    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= len; i++) {
            int p1 = Integer.parseInt(s.substring(i - 1, i));
            if (p1 > 0)
                dp[i] = dp[i - 1];
            int p2 = Integer.parseInt(s.substring(i - 2, i));
            if (p2 > 9 && p2 < 27)
                dp[i] += dp[i - 2];
        }
        return dp[len];
    }
}