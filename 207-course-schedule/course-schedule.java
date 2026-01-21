class Solution {

    public boolean dfs(int node,boolean[] vis,boolean[] pathvis,ArrayList<ArrayList<Integer>> adj){

        vis[node]=true;
        pathvis[node ]=true;

        for(int it:adj.get(node)){
            //if the node is not visited
            if(!vis[it] ){
                if(dfs(it,vis,pathvis,adj)) /// if in future it returns true
                return true;
            }
            //if the node is visted but it has to be on the same path
            else if(pathvis[it])
            return true;
        }
        pathvis[node]=false;  //backtrack
        return false;

    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
         ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

      
       
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
            for (int[] p : prerequisites) {
           adj.get(p[1]).add(p[0]);
        }

        

        boolean[] vis=new boolean[numCourses];
        boolean[] pathvis=new boolean[numCourses];

        for(int i=0;i<adj.size();i++){
            if(!vis[i])
            {
                if(dfs(i,vis,pathvis,adj))
                return false;
            }
        }
        return true;
    }
}