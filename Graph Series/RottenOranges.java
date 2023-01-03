class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length, init = 0, fin = 0;
        boolean[][] vis = new boolean[m][n];
        Queue<Pair> qpair = new LinkedList<>();

        for(int i=0;i<m;++i) {
            for(int j=0;j<n;++j) {
                if(grid[i][j]==2) {
                    qpair.add(new Pair(i, j, 0));
                    vis[i][j]=true;
                }

                if(grid[i][j]==1) init++;
            }
        }
        // If there are no fresh oranges return 0
        if(init==0) return 0;
        
        int[] xArr = {-1, 0, 1, 0};
        int yArr[] = {0, 1, 0, -1};
        int cur_i=-1, cur_j=-1, x, y, max_ind=-1;

        while(!qpair.isEmpty()) {
            Pair p = qpair.poll();
            x = p.xcor; y = p.ycor;
            max_ind = Math.max(max_ind, p.level);

            for(int k = 0; k<4; ++k) {
                cur_i = x + xArr[k];
                cur_j = y + yArr[k];
                if(cur_i>=0 && cur_i<m && cur_j>=0 && cur_j<n && !vis[cur_i][cur_j] && grid[cur_i][cur_j]==1) {
                        qpair.add(new Pair(cur_i, cur_j, p.level+1));
                        grid[cur_i][cur_j] = 2;
                        vis[cur_i][cur_j] = true;
                        ++fin;
                } 
            }
            
        }

        if(init!=fin) 
            return -1;
        
        return max_ind; 
         

    }
}
class Pair {
    int xcor, ycor, level;
    Pair(int x, int y, int k) {
        xcor = x;
        ycor = y;
        level = k;
    }
}
