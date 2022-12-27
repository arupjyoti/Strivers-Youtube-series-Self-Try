class Solution {
    public int findCircleNum(int[][] iC) {
        int len = iC.length;
        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<ArrayList<Integer>>();
        // converting adj matrix to list
        for(int i=0; i<len; ++i) {
            adjLs.add(new ArrayList<Integer>());
        }
        
        
        for(int i=0; i<len; ++i){
            for(int j=0; j<len; ++j){
                if(iC[i][j]==1 && i!=j) {
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }
            }  
        }

        int[] vis = new int[len];
        int cnt = 0;

        for(int i=0; i<len; ++i){
            if(vis[i] == 0) {
                cnt++;
                dfs(i,adjLs,vis);
            }
        }

        return cnt;
        
    }

    public void dfs(int i, ArrayList<ArrayList<Integer>> adjLs, int[] vis) {
        vis[i] = 1;
        for(Integer v : adjLs.get(i)) {
            if(vis[v] == 0) {
                dfs(v, adjLs, vis);
            }
        }
    }
}