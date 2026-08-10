class Solution {
    private  boolean isSafe(char[][] board, int row, int col) {
    // 1. Check this column for any queen above
    for (int i = 0; i < row; i++) {
        if (board[i][col] == 'Q') return false;
    }
    // 2. Check top-left (North-West) diagonal
    for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
        if (board[i][j] == 'Q') return false;
    }
    // 3. Check top-right (North-East) diagonal
    for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
        if (board[i][j] == 'Q') return false;
    }
    return true;
}
private  void nQueen(char[][] board, int row,List<List<String>> ans) {
    int n = board.length;
    if (row == n) {
        // copy 2D Array into list of string 
        List<String> l = new ArrayList<>();
        for (int i = 0; i < n; i++) {
           String str = "";
           for(int j=0; j<n; j++){
            str +=board[i][j];
           }
           l.add(str);
        }
        ans.add(l);
        return;
       
    }
    for (int j = 0; j < n; j++) {
        if (isSafe(board, row, j)) {
            board[row][j] = 'Q';
            nQueen(board, row + 1,ans);
            board[row][j] = '.'; // Backtrack
        }
    }
}
    public int totalNQueens(int n) {
        
        char[][] board = new char [n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }      
    }
     List<List<String>> ans = new ArrayList<>();
        nQueen(board,0,ans);
        return ans.size();
}
}