package logic;

import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class FileWrite {
    private int x;
    private int y;
    private String name;

    public FileWrite(Config config, FileRead read) {
        this.name = config.getOutFile();
        this.x = read.getX();
        this.y = read.getY();
    }

    public boolean writeFile(Cell[][] last) {
        try {
            PrintWriter print = new PrintWriter(name);
            print.println(x +" " + y);

            for(int i = 0; i < x; i++){
                for(int j = 0; j < y; j++){
                    if(last[i][j] instanceof Head)
                        print.println("Head" + " " + i+" " + j);
                    else if (last[i][j] instanceof Tail)
                        print.println("Tail" + " " + i+" " + j);
                    else if (last[i][j] instanceof Conductor)
                        print.println("Conductor" + " " + i+" " + j);
                }
            }

            print.close();
        } catch (FileNotFoundException e) {
            System.out.println("Nie można otworzyć pliku zapisu.");
            return false;
        }

        return true;
    }

}


