public class Main {


    public static void main(String[] args) {
        String nazwapliku = "plik.txt"; //to idzie od czarka
        String nazwawyjsciowego = "plikout.txt";  //to idzie od czarka
        int genNumber = 10; //to idzie od czarka
//        int x = 10; //to idzie od czarka
//        int y = 10; //to idzie od czarka



        Config config = new Config(5,10, nazwapliku, nazwawyjsciowego);
        FileRead read = new FileRead(config);
        Grid grid = new Grid(read);
        read.setSize();
        read.readFileWW();
        read.printGrid();

        Generation gen = new Generation(read);

        for(int i = 0; i < genNumber; i++ ) {
            System.out.println();
            System.out.println("Gen #" + i);
            gen.generate(read);
        }







//            read.readFileWW();
//
//            Grid myGrid = new Grid(x, y);
//
//            read.printGrid();






    }
}
