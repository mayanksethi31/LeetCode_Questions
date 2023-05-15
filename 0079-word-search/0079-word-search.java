class Solution {

  int num_R;
  int num_C;
  boolean res;
  boolean[][] visited;
  public boolean exist(char[][] board, String word) {
    num_R = board.length;
    num_C = board[0].length;
    visited = new boolean[num_R][num_C];
    for (int i = 0; i < num_R; i++) {
      for (int j = 0; j < num_C; j++) {
        if (word.charAt(0) == board[i][j] && (dfs(i, j, 0, word, board))) {
          return true;
        }
      }
    }
    return false;
  }
  private boolean dfs(int r, int c, int i, String word, char[][] board) {
    if (i == word.length()) return true;
    if (r < 0 || c < 0 || c >= num_C || r >= num_R || visited[r][c] == true || word.charAt(i) != board[r][c]) return false;

    visited[r][c] = true;
    res = dfs(r + 1, c, i + 1, word, board) || dfs(r - 1, c, i + 1, word, board) || dfs(r, c + 1, i + 1, word, board) || dfs(r, c - 1, i + 1, word, board);
    visited[r][c] = false;
    return res;
  }
}