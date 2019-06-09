package logic;


public class Generation {
    private int x;
    private int y;
    private int genNumber;
    private FileRead fr;
    private Config cfg;

    public Generation(FileRead read, Config config) {
        this.x = read.getX();
        this.y = read.getY();
        this.genNumber = config.getGenNumber();
        this.fr = read;
        this.cfg = config;
    }

    public Generation () {}

    public void setargs (FileRead read, Config config) {
        this.x = read.getX();
        this.y = read.getY();
        this.genNumber = config.getGenNumber();
        this.fr = read;
        this.cfg = config;
    }
/*
    public logic.Cell[][] generatenext(Cell[][] cells) {
        Rules rules = new Rules();

            rules.updateNeighbourCount(cells, x, y);
            rules.changeStates(cells, x, y);
            System.out.println();

        return cells;
    }

    public logic.Cell[][] generate(FileRead read) {
        Grid grid = new Grid(this.x, this.y);
        Rules rules = new Rules();
        System.out.println();
        Cell[][] cells = grid.createInitial(x, y, read.getTemp());


        for (int k = 0; k < genNumber; k++) {
            rules.updateNeighbourCount(cells, x, y);
            //nieużywane, ale pewnie będzie potrzebne do wyświetlania? idk
            Cell[][] previousCells = cells;
            rules.changeStates(cells, x, y);


            //drukowanie, do usunięcia
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
    }*/

    public logic.Grid generateFirst(FileRead read) {
        Grid grid = new Grid(this.x, this.y);
        Rules rules = new Rules();
        System.out.println();
        Cell[][] cells = grid.createInitial(x, y, read.getTemp());

        return grid;
    }

    public logic.Cell[][] generateNext(Cell[][] cells){
        Rules rules = new Rules();

        rules.updateNeighbourCount(cells, x, y);
        rules.changeStates(cells, x, y);

        return cells;
    }
}


