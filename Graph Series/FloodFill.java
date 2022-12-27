class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        boolean[][] vis = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();
        int[] xcoor = {-1, 0, 1, 0};
        int[] ycoor = {0, 1, 0, -1};
        int col = image[sr][sc];
        q.add(new Pair(sr,sc));
        vis[sr][sc] = true;
        image[sr][sc] = color;

        while(!q.isEmpty()) {
            Pair pr = q.poll();
            int x = pr.i, y = pr.j;

            for(int i=0; i<4; ++i) {
                    int nrow = x + xcoor[i];
                    int ncol = y + ycoor[i];

                    if( nrow>=0 && nrow<m && ncol>=0 && ncol<n && !vis[nrow][ncol] && (image[nrow][ncol]==col)) {
                        vis[nrow][ncol] = true;
                        image[nrow][ncol] = color;
                        q.add(new Pair(nrow, ncol));
                    }
                }
        }

        return image;
    }
}

class Pair {
    int i; int j;
    Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
