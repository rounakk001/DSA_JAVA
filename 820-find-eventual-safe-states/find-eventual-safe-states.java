class Solution {


    public boolean dfs(int node,int[] vis,int[] pathvis,int[] check,int[][] graph){
        vis[node]=1;
        pathvis[node]=1;
        check[node]=0;

        for(int it:graph[node]){
            if(vis[it]==0){
                if(dfs(it,vis,pathvis,check,graph)==true){
                    check[node]=0;
                    return true;
                }}
                else if(pathvis[it]==1)
                {
                    check[node]=0;
                    return true;
                }
            
        }
        check[node]=1;
        pathvis[node]=0;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V=graph.length;
        int vis[]=new int[V];
        int pathvis[]=new int[V];
        int check[]=new int [V];
        
        for(int i=0;i<graph.length;i++){
            
                if(vis[i]==0){
                    dfs(i,vis,pathvis,check,graph);
                }
            
        }

        List<Integer> result=new ArrayList<>();

        for(int i=0;i<V;i++){
            if(check[i]==1)
            result.add(i);
        }

        return result;

    }
}