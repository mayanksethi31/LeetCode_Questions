class Solution {
    Set<Integer> positive;
    Set<Integer> negative;
    Set<Integer> columns;
    List<String> row_list;
    List<List<String>> result;

    public List<List<String>> solveNQueens(int n) 
    {
        positive = new HashSet<>();
        negative = new HashSet<>();
        columns = new HashSet<>();
        row_list = new ArrayList<>();
        result = new ArrayList<>();

        String[][] board = new String[n][n];
        
        backtrack(0, n, board);
       
        return result;
    }
    private void backtrack (int row, int size, String[][] board)
    {   
        if(row_list.size()==size)
        {
            row_list = new ArrayList<>();
        }
        if (row==size)
        {
            for(int k=0; k<size; k++)
            {   String r = "";
                for(int l=0; l<size; l++)
                {
                    if (board[k][l]=="Q")
                    {
                        r+="Q";
                    }
                    else
                    {
                        r+=".";
                    }
                }
                row_list.add(r);
            }
            result.add(row_list);
            return;
        }

        for(int j=0; j<size; j++)
        {
            if (!columns.contains(j) && !positive.contains(row+j) && !negative.contains(row-j))
            {
                columns.add(j);
                positive.add(row+j);
                negative.add(row-j);
                board[row][j] = "Q";
                backtrack (row+1, size, board);
                board[row][j] = ".";
                columns.remove(j);
                positive.remove(row+j);
                negative.remove(row-j);
            }
        }
    }
}