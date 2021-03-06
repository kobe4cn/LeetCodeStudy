public class NumberofIslands_200 {
    public static void main(String[] args) {



    }
    public static int getNumberofIsland(char[][] grid){
        int islandnum=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    islandnum++;
                    islandSearch(grid,i,j);
                }

            }

        }
        return islandnum;
    }

    public static void islandSearch(char[][] grid,int i, int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[i].length || grid[i][j]!='1') return;
        grid[i][j]='i';
        islandSearch(grid,i,j+1);
        islandSearch(grid,i,j-1);
        islandSearch(grid,i-1,j);
        islandSearch(grid,i+1,j);
    }
}
