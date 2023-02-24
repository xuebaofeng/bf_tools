package leetcode;

import java.util.Arrays;

public class SurroundedRegions130 {
    char[][] board;
    int m;
    int n;

    public static void main(String[] args) {
        SurroundedRegions130 s = new SurroundedRegions130();
        s.solve(new char[][]{{'O', 'X', 'O'}, {'X', 'O', 'X'}, {'O', 'X', 'O'}});
        Arrays.stream(new int[]{1,2}).reduce(0, (a, b)-> a^b);
    }

    public void solve(char[][] board) {
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if ((i == 0 || j == 0 || i == m - 1 || j == n - 1) && board[i][j] == 'O') dfs(i, j);
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (board[i][j] == ' ') board[i][j] = 'O';
                else board[i][j] = 'X';
            }
    }

    void dfs(int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] == 'X' || board[i][j] == ' ') return;
        board[i][j] = ' ';
        dfs(i + 1, j);
        dfs(i - 1, j);
        dfs(i, j + 1);
        dfs(i, j - 1);
    }
}