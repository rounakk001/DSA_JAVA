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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         List<List<Integer>> result=new ArrayList<>();

       if(root==null)
       return result;
    
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        boolean lefttoright=true;

        while(!q.isEmpty()){
          int size=q.size();
          List<Integer> sublist=new ArrayList<>();
            for (int i = 0; i < size; i++) {
                sublist.add(0);
            }

          for(int i=0;i<size;i++){
             TreeNode node=q.peek();
             q.remove();

             //find index
             int index=(lefttoright)?i:(size-1-i);

             sublist.set(index,node.val);

             if(node.left!=null)
             q.add(node.left);
             if(node.right!=null)
             q.add(node.right);
          }
          lefttoright=!lefttoright;
          result.add(sublist);
        }
          

      return result;
    }
}