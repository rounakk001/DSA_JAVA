class Solution {
    public void DFS(int row,int col,int[][] ans,int[] delrow,int[] delcol,int[][] image,int initcolor,int newcolor){

        ans[row][col]=newcolor;
        int n=image.length;
        int m=image[0].length;
        for(int i=0;i<4;i++){
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol]==initcolor && ans[nrow][ncol]!=newcolor){
                DFS(nrow,ncol,ans,delrow,delcol,image,initcolor,newcolor);
            }
        }

    

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int initcol=image[sr][sc];
        int ans[][]=image;
        int[] delrow={-1,0,+1,0};
        int[] delcol={0,+1,0,-1};

        DFS(sr,sc,ans,delrow,delcol,image,initcol,color);

        return ans;

    }
}