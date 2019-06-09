public class Generation {
    private int x;
    private int y;
    private int genNumber;

    public Generation(FileRead read, Config config){
        this.x = read.getX();
        this.y = read.getY();
        this.genNumber = config.getGenNumber();

    }

    public Cell[][] generate(FileRead read){
        Grid grid = new Grid(this.x, this.y);
        Rules rules = new Rules();
        System.out.println();
        Cell[][] cells = grid.createInitial(x,y, read.getTemp());
        

        for (int k = 0; k < genNumber; k++) {
            rules.updateNeighbourCount(cells,x,y);
            rules.changeStates(cells, x, y);


            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (cells[i][j] instanceof Empty)
                        System.out.printf("E ");
                    else if (cells[i][j] instanceof Head)
                        System.out.printf("H ");
                    else if (cells[i][j] instanceof Tail)
                        System.out.printf("T ");
                    else if (cells[i][j] instanceof Conductor)
                        System.out.printf("C ");
                }
                System.out.printf("%n");

            }
            System.out.println();
        }

        return cells;


















        //int x =
        //Grid grid = new Grid(x,y);
    }

//    public void createInitial (int x, int y, String[][] input){
//
//        Grid grid = new Grid(10,10);
//
//        for(int i = 0; i < x; i ++){
//            for (int j = 0; i < y; j++){
//                if(input[i][j]=="E"){
//                    grid.grid[i][j] = new Empty();
//                }
//                else if(input[i][j]=="H"){
//                    grid.grid[i][j] = new Head();
//                }
//                else if(input[i][j] == "T"){
//                    grid.grid[i][i] = new Tail();
//                }
//                else {
//                    grid.grid[i][j] = new Conductor();
//                }
//
//            }
//        }
//    }


}

