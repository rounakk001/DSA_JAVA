class Solution {

    public int max(int mat[][],int n,int m,int col){
        int maxans=-1;
        int index=-1;

        for(int i=0;i<n;i++){
            if(mat[i][col]>maxans){
                maxans=mat[i][col];
                index=i;
            }
        }
        return index;
    }
    public int[] findPeakGrid(int[][] mat) {
    int n=mat.length;
    int m=mat[0].length;

    int low=0,high=m-1;

    while(low<=high){
        int mid=low+(high-low)/2;

        int row=max(mat,n,m,mid);  //yaha max nikal ke upar neeche sabse maximum nikal liye 
        int left=mid-1>=0?mat[row][mid-1]:-1;  //yaha left direction 
        int right=mid+1<m?mat[row][mid+1]:-1;   //yaha right direction

        if(mat[row][mid]>left && mat[row][mid]>right)
        return new int[]{row,mid};

        else if(mat[row][mid]<left)
        high=mid-1;
        else
        low=mid+1;
        

    }
    return new int[]{0,0};
    }
}