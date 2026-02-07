/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void parentfinder(TreeNode root, Map<TreeNode,TreeNode> parent_track){
      Queue<TreeNode> q=new LinkedList<>();
      q.add(root);

      while(!q.isEmpty()){
        int size=q.size();

        for(int i=0;i<size;i++){
        TreeNode current=q.poll();

        if(current.left!=null)
        {
            q.add(current.left);
            parent_track.put(current.left,current);
        }
        if(current.right!=null)
        {
            q.add(current.right);
            parent_track.put(current.right,current);
        }
       }
      }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parent_track=new HashMap<>();
        parentfinder(root,parent_track);
        
        Queue<TreeNode> q=new LinkedList<>();
        Map<TreeNode,Boolean> visited=new HashMap<>();
        int currlevel=0;

        q.add(target);

        visited.put(target,true);

        while(!q.isEmpty()){
            int size=q.size();

            if(currlevel==k)
            break;

            currlevel++;

            for(int i=0;i<size;i++){
               TreeNode curr=q.poll();
               //left child
               if(curr.left!=null && visited.get(curr.left)==null){
                q.add(curr.left);
                visited.put(curr.left,true);
               }
               //right child
               if(curr.right!=null && visited.get(curr.right)==null){
                q.add(curr.right);
                visited.put(curr.right,true);
               }

                //parent bhi check kr le bsdk
                if(parent_track.get(curr)!=null && visited.get(parent_track.get(curr))==null){
                    q.add(parent_track.get(curr));
                    visited.put(parent_track.get(curr),true);
                }
               
            }
        }

        List<Integer> arr=new ArrayList<>();

        while(!q.isEmpty()){
            TreeNode value=q.poll();
            arr.add(value.val);
        }
        return arr;
    }
}