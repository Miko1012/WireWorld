package folder;

public class Grid {
    private int xSize;
    private int ySize;
    private Cell[][] grid;


    public  Grid (FileRead read){
        this.xSize = read.getX();
        this.ySize = read.getY();
        this.grid = new Cell[xSize][ySize];
    }

    public Grid(int x, int y){
        this.xSize = x;
        this.ySize = y;
        this.grid = new Cell[xSize][ySize];
    }

    public int getxSize() {
        return xSize;
    }

    public int getySize() {
        return ySize;
    }

//    public void setCellAtIndex(int x, int y, Cell state){
//        this.grid[x][y] = state;
//    }

    //void fillGrid(int x, int y, )

//    void fillGrid(int x, int y, Cell cell, String[][] temp){
//        for(int i = 0; i < x; i++){
//            for (int j = 0; j < y; j++)
//            {
//                switch (temp[i][j]){
//                    case "E":
//                        this.grid[i][j] = new Head();
//                        break;
//                    case"C":
//                        this.grid
//
//
//                }
//            }
//        }



    public Cell[][] createInitial (int x, int y, String[][] input){
        //Grid grid = new Grid(x,y);
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

    public Cell[][] getGrid(){
        return this.grid;
    }

    public Cell getCell(int x, int y){
        return this.grid[x][y];
    }
}
