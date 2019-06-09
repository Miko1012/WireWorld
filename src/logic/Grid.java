package logic;


public class Grid {
    private int xSize;
    private int ySize;
    private Cell[][] grid;

    public void savegrid(Cell[][] arr) {this.grid = arr;}
    public Cell[][] getgrid () {return this.grid;}

    public Grid(int x, int y){
        this.xSize = x;
        this.ySize = y;
        this.grid = new Cell[xSize][ySize];
    }

    public Grid(){}

    public Cell[][] getCells(){
        return grid;

    }

    public Cell[][] createInitial (int x, int y, String[][] input){
        for(int i = 0; i < x; i ++){
            for (int j = 0; j < y; j++){
                if(input[i][j]=="E"){
                    grid[i][j] = new Empty();
                }
                else if(input[i][j]=="H"){
                    grid[i][j] = new Head();
                }
                else if(input[i][j] == "T"){
                    grid[i][j] = new Tail();
                }
                else {
                    grid[i][j] = new Conductor();
                }
            }
        }
        return grid;
    }
}
