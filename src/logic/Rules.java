package logic;


public class Rules {


    public int countHeadNeighbours(int x, int y, Cell[][] grid, int xSize, int ySize){
        int n = 0;
        if(x!= 0 && grid[x-1][y] instanceof Head) //2)
            n++;
        if(y!= 0 && grid[x][y-1] instanceof Head) //4)
            n++;
        if(x!= xSize-1 && grid[x+1][y] instanceof Head) //7)
            n++;
        if(y!= ySize-1 && grid[x][y+1] instanceof Head) //5)
            n++;
        if(x!= 0 && y!=0 && grid[x-1][y-1] instanceof Head) //1)
            n++;
        if(x!=xSize-1 && y!=0 && grid[x+1][y-1] instanceof Head) //6
            n++;
        if(x!= 0 && y!= ySize-1 && grid[x-1][y+1] instanceof Head) //3)
            n++;
        if(y!= ySize-1 && x!= xSize-1 && grid[x+1][y+1] instanceof Head) //8)
            n++;
        return n;
    }

    public Cell[][] updateNeighbourCount(Cell[][] cells, int x, int y){
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                if(cells[i][j] instanceof Conductor) {
                    int n = countHeadNeighbours(i,j,cells,x,y);
                    cells[i][j].setHeadNeighbours(n);
                }
            }
        }
        return cells;
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
