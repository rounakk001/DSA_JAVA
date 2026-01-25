class Solution {
    public List<Integer> generaterows(int row){
        int ans=1;
         List<Integer> res=new ArrayList<>();
         res.add(1);
        for(int i=1;i<row;i++){
            ans=ans*(row-i);
            ans=ans/i;
            res.add(ans);
         }
         return res;
    }
    public List<List<Integer>> generate(int numRows) {
        List<Integer> templis=new ArrayList<>();
        List<List<Integer>> result=new ArrayList<>();

        for(int i=1;i<=numRows;i++){
            result.add(generaterows(i));
        }
        

        return result;
        
    }
}