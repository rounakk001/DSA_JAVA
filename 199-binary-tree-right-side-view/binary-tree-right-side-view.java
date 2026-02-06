/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
  
    List<Integer> ans=new ArrayList<>();

    public List<Integer> help(TreeNode root,int level){
     if(root==null)
     return ans;
     
    
    if(ans.size()==level){
        ans.add(root.val);
    }

     

     help(root.right,level+1);
     help(root.left,level+1);
    
    return ans;
    }



    public List<Integer> rightSideView(TreeNode root) {
    return help(root,0);
}
}
