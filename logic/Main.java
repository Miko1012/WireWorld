public class Main {


    public static void main(String[] args) {
        //te rzeczy idą z gui
        String plikin = "plik.txt";
        String plikout = "plikout.txt";
        int genNumber = 10;


        Config config = new Config(5,10, plikin, plikout);
        FileRead read = new FileRead(config);


        boolean ok = read.setSize();
        if(ok) {
            read.readFileWW();
            read.printGrid();
            Generation gen = new Generation(read, config);
            gen.generate(read);
        }

    }
}
