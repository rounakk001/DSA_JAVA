class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> arr=new ArrayList<>();
        int top=0;
        int left=0;
        int bottom=matrix.length-1;
        int right=matrix[0].length-1;

        while(top<=bottom && left<=right){
            //right side
            if(top<=bottom){
            for(int j=left;j<=right;j++){
               arr.add(matrix[top][j]);
            }
            top++;
            }

            //down side
 if(left<=right){
            for(int i=top;i<=bottom;i++){
               arr.add(matrix[i][right]);
            }
            right--;
 }

            //left side
            if(top<=bottom){
            for(int j=right;j>=left;j--){
               arr.add(matrix[bottom][j]);
            }
            bottom--;
            }

            //up side
            if(left<=right){
            for(int i=bottom;i>=top;i--){
               arr.add(matrix[i][left]);
            }
            left++;

            }
        }
        return arr;
    }
}