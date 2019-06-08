public class Rules {


    public int countHeadNeighbours(int x, int y, Cell[][] grid, int xSize, int ySize){
        int n = 0;
        if(x!= 0 && grid[x-1][y] instanceof Head)
            n++;
        if(y!= 0 && grid[x][y-1] instanceof Head)
            n++;
        if(x!= xSize-1 && grid[x+1][y] instanceof Head)
            n++;
        if(y!= ySize-1 && grid[x][y+1] instanceof Head)
            n++;
        if(x!= 0 && y!=0 && grid[x-1][y-1] instanceof Head)
            n++;
        if(x!=0 && y!=0 && grid[x+1][y-1] instanceof Head)
            n++;
        if(x!= 0 && y!= ySize-1 && grid[x-1][y+1] instanceof Head)
            n++;
        if(y!= ySize-1 && x!= xSize-1 && grid[x+1][y+1] instanceof Head)
            n++;
        return n;
    }


    public Cell[][] changeStates(Cell[][] grid, int xSize, int ySize){
        for(int i = 0; i < xSize; i++){
            for (int j = 0; j < ySize; j++){
                if (grid[i][j] instanceof Conductor){
                    if (grid[i][j].getHeadNeighbours() == 1 || grid[i][j].getHeadNeighbours() == 2)
                        grid[i][j] = new Head();
                }
                else if(grid[i][j] instanceof Tail)
                    grid[i][j] = new Conductor();

                else if(grid[i][j] instanceof Head)
                    grid[i][j] = new Tail();
            }
        }
        return grid;
    }



}
