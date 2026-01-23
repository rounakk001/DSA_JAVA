class Solution {

    public boolean dfs(int node, boolean[] vis, boolean[] vispath,
                       ArrayList<ArrayList<Integer>> adj,
                       Stack<Integer> st) {

        vis[node] = true;
        vispath[node] = true;

        for (int it : adj.get(node)) {
            if (!vis[it]) {
                if (dfs(it, vis, vispath, adj, st))
                    return true; // cycle found
            } 
            else if (vispath[it]) {
                return true; // cycle found
            }
        }

        vispath[node] = false; // backtrack
        st.push(node);
        return false;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            adj.add(new ArrayList<>());

        for (int[] p : prerequisites)
            adj.get(p[1]).add(p[0]);

        boolean[] vis = new boolean[numCourses];
        boolean[] vispath = new boolean[numCourses];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < numCourses; i++) {
            if (!vis[i]) {
                if (dfs(i, vis, vispath, adj, st))
                    return new int[0]; // cycle exists
            }
        }

        int[] topo = new int[numCourses];
        int i = 0;
        while (!st.isEmpty())
            topo[i++] = st.pop();

        return topo;
    }
}
