package logic;

public class Main {


    public static void main(String[] args) {
        //te rzeczy idą z gui
        String plikin = "plik.txt";
        String plikout = "plikout.txt";
        int genNumber = 10;


        Config config = new Config(5, genNumber, plikin, plikout);
        FileRead read = new FileRead(config);


        boolean ok = read.setSize();
        if(ok) {
            read.readFile();
            read.printGrid();
            Generation gen = new Generation(read, config);
            Cell[][] last =  gen.generate(read);
            FileWrite write = new FileWrite(config, read);
            write.writeFile(last);
        }



    }
}
