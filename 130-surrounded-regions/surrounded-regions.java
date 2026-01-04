class Solution {

    public void dfs(int row,int col,int vis[][],char board[][],int delrow[],int delcol[])  {
         vis[row][col]=1;
         int n=board.length;
         int m=board[0].length;

         for(int i=0;i<4;i++){
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];

            if(nrow>=0 && nrow<n && ncol >=0 && ncol<m && board[nrow][ncol]=='O'&& vis[nrow][ncol]==0){
                
                dfs(nrow,ncol,vis,board,delrow,delcol);
            }
         }
    }
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;

        int vis[][]=new int[n][m];

        int delrow[]={-1,0,+1,0};
        int delcol[]={0,+1,0,-1};

        //rows
        for(int j=0;j<m;j++){
            //first row
            if(board[0][j]=='O' && vis[0][j]==0)
            dfs(0,j,vis,board,delrow,delcol);

            //last row
            if(board[n-1][j]=='O' && vis[n-1][j]==0)
            dfs(n-1,j,vis,board,delrow,delcol);


        }

        //column
        for(int i=0;i<n;i++){
            //first column
            if(board[i][0]=='O' && vis[i][0]==0){
                dfs(i,0,vis,board,delrow,delcol);
            }
            //last column
            if(board[i][m-1]=='O' && vis[i][m-1]==0){
                dfs(i,m-1,vis,board,delrow,delcol);
            }

        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && board[i][j]=='O')
                board[i][j]='X';
            }
        }


    }
}