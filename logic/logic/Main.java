public class Main {


    public static void main(String[] args) {
        //te rzeczy idą z gui
        String nazwapliku = "plik.txt";
        String nazwawyjsciowego = "plikout.txt";
        int genNumber = 10;


        Config config = new Config(5,10, nazwapliku, nazwawyjsciowego);
        FileRead read = new FileRead(config);


        boolean ok = read.setSize();
        if(ok) {
            read.readFileWW();
            read.printGrid();
            Generation gen = new Generation(read, config);
            gen.generate(read);

//            //to do wyjebania potem
//            for (int i = 0; i < genNumber; i++) {
//                System.out.println();
//                System.out.println("Gen #" + i);
//                gen.generate(read);
//            }
        }

    }
}
