class pair{
    int row, col;
    pair(int row,int col){
        this.row=row;
        this.col=col;
    }
    }
    class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;


        int vis[][]=new int[n][m];
        int dist[][]=new int[n][m];
       

       if(grid[0][0]==1 || grid[n-1][n-1]==1)
       return -1;

       for(int i=0;i<dist.length;i++){
        Arrays.fill(dist[i],-1);
       }

        Queue<pair> q=new LinkedList<>();

        q.add(new pair(0,0));
        vis[0][0]=1;
        dist[0][0]=1;




        while(!q.isEmpty()){

           int row=q.peek().row;
           int col=q.peek().col;

           q.remove();


           for(int delrow=-1;delrow<=1;delrow++){
            for(int delcol=-1;delcol<=1;delcol++){
                int nrow=row+delrow;
                int ncol=col+delcol;

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]==0){
                    q.add(new pair(nrow,ncol));
                    vis[nrow][ncol]=1;
                    dist[nrow][ncol]=dist[row][col]+1;
                }
            }
           }
        }

        return dist[n-1][m-1];
    }
}