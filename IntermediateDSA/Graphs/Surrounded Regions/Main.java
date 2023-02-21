class Solution {

    static class Pair {
        int row;
        int col;
        Pair(int r, int c){
            row = r;
            col = c;
        }
    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(i == 0){
                for(int j=0; j<m; j++){
                    if(board[i][j] == 'O') q.add(new Pair(i, j));
                }
            }
            else if(i == n-1){
                for(int j=0; j<m; j++){
                    if(board[i][j] == 'O') q.add(new Pair(i, j));
                }
            }
            else{
                if(board[i][0] == 'O') q.add(new Pair(i, 0));
                if(board[i][m-1] == 'O') q.add(new Pair(i, m-1));
            }
        }

        while(!q.isEmpty()){
            Pair p = q.poll();
            int i = p.row;
            int j = p.col;
            if(vis[i][j]) continue;
            vis[i][j] = true;

            //top
            if(i-1>=0 && !vis[i-1][j] && board[i-1][j] == 'O'){
                q.add(new Pair(i-1, j));
            }

            //right
            if(j+1<m && !vis[i][j+1] && board[i][j+1] == 'O'){
                q.add(new Pair(i, j+1));
            }

            //down
            if(i+1<n && !vis[i+1][j] && board[i+1][j] == 'O'){
                q.add(new Pair(i+1, j));
            }

            //left
            if(j-1>=0 && !vis[i][j-1] && board[i][j-1] == 'O'){
                q.add(new Pair(i, j-1));
            }

        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(vis[i][j]){
                    board[i][j] = 'O';
                }else{
                    board[i][j] = 'X';
                }
            }
        }

    }
}