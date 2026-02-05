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
    class Pair{
        TreeNode node;
        int vertical,level;
        Pair(TreeNode node,int vertical,int level){
            this.node=node;
            this.vertical=vertical;
            this.level=level;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        

         TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap<>();
         Queue<Pair> q=new LinkedList<>();

         q.add(new Pair(root,0,0));

         while(!q.isEmpty()){
            Pair p=q.poll();
            TreeNode node=p.node;
            int vertical=p.vertical;
            int level=p.level;

            map.putIfAbsent(vertical,new TreeMap<>());
            map.get(vertical).putIfAbsent(level,new PriorityQueue<Integer>());
            map.get(vertical).get(level).add(node.val);

            if(node.left!=null)
            q.add(new Pair(node.left,vertical-1,level+1));
            if(node.right!=null)
            q.add(new Pair(node.right,vertical+1,level+1));
         }

         

         for(TreeMap<Integer,PriorityQueue<Integer>> levels:map.values()){

            ArrayList<Integer> vert=new ArrayList<>();

            for(PriorityQueue<Integer> pq:levels.values()){
                while(!pq.isEmpty()){
                    vert.add(pq.poll());
                }
            }
            ans.add(vert);
         }
         return ans;
    }
}