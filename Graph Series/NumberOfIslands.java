class Solution {
    // public int numIslands(char[][] grid) {
    //     int m = grid.length;
    //     int n = grid[0].length;
    //     int len = n*m;
    //     //int max = m>n?m:n;
    //     boolean[][] cR = new boolean[m][n+1];
    //     boolean[][] cD = new boolean[m+1][n];
    //     ArrayList<ArrayList<Integer>> aL = new ArrayList<ArrayList<Integer>>();

    //     for(int i=0; i<=len; ++i) {
    //         aL.add(new ArrayList<Integer>());
    //     }
    //     for(int i=0; i<m; ++i) {
    //         for(int j=0; j<n; ++j){
    //             if(grid[i][j]=='1') {
    //                 if(j>0 && cR[i][j]==true) {
    //                     aL.get(n*i+j).add(n*i+j-1);
    //                     aL.get(n*i+j-1).add(n*i+j);
    //                 }
    //                 if(i>0 && cD[i][j]==true) {
    //                     aL.get(n*(i-1)+j).add(n*i+j);
    //                     aL.get(n*i+j).add(n*(i-1)+j);
    //                 }
    //                 cR[i][j+1]=true;
    //                 cD[i+1][j]=true;
    //                 aL.get(n*i+j).add(n*i+j);
    //             }
    //         }
    //     }

    //     boolean[] vis = new boolean[len+1];
    //     int cnt=0;

    //     for(int i=0; i<len; ++i){
    //         if(aL.get(i).size()>0 && vis[i]==false){
    //             cnt++;
    //             dfs(i, aL, vis);
    //         }
    //     }

    //     return cnt;

    // }

    // public void dfs(int i, ArrayList<ArrayList<Integer>> aL, boolean[] vis) {
    //     vis[i]=true;

    //     for(Integer v : aL.get(i)) {
    //         if(vis[v]==false) {
    //             dfs(v, aL, vis);
    //         }
    //     }
    // }
    
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int cnt=0;
        boolean[][] vis = new boolean[m][n];

        for(int i=0; i<m; ++i) {
            for (int j=0; j<n; ++j) {
                if(grid[i][j]=='1' && vis[i][j] == false) {
                    cnt++;
                    bfs(i, j, vis, grid);
                }
            }
        }

        return cnt;
    }

    public void bfs(int i, int j, boolean[][] vis, char[][] g) {
        vis[i][j]=true;
        Queue<Pair> q = new LinkedList<>();
        int m = g.length, n = g[0].length;
        int x,y;
        q.add(new Pair(i,j));

        while(!q.isEmpty()) {
            Pair p = q.poll();
            x = p.i; y = p.j;
            if(x+1<m && g[x+1][y]=='1' && vis[x+1][y]==false) {
                    q.add(new Pair(x+1,y));
                    vis[x+1][y]=true;
            } 
            if(x-1>=0 && g[x-1][y]=='1' && vis[x-1][y]==false) {
                    q.add(new Pair(x-1,y));
                    vis[x-1][y]=true;
            }
            if(y+1<n && g[x][y+1]=='1' && vis[x][y+1]==false) {
                    q.add(new Pair(x,y+1));
                    vis[x][y+1]=true;
            }
            if(y-1>=0 && g[x][y-1]=='1' && vis[x][y-1]==false) {
                    q.add(new Pair(x,y-1));
                    vis[x][y-1]=true;
                
            } 
            
        }
    }

}

class Pair {
        int i; int j;
        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
