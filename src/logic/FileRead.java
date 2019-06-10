package logic;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.String;


public class FileRead {
    public String inName;
    private int x;
    private int y;
    private String[][] temp;

    public FileRead(Config config) { this.inName = config.getInFile(); }

    //public FileRead () {}

    public void setConfig(Config config) {this.inName = config.getInFile();}

    public FileRead (String inName){
        this.inName = inName;
    }

    public FileRead (String inName, int x, int y){
        this.inName = inName;
        this.x = x;
        this.y = y;
        this.temp = new String[x][y];
    }

    public boolean setSize(){
        try{
            Scanner in = new Scanner(Paths.get(inName));
        }catch (IOException e){
            System.out.println("Plik nie istnieje! ");
            return false;
        }

        try {
            Scanner in = new Scanner(Paths.get(inName));
            this.x = in.nextInt();
            this.y = in.nextInt();
            if(x<=1 || y <=1){
                System.out.println("Niepoprawne wymiary siatki.");
                return false;
            }
            this.temp = new String[x][y];
        } catch (IOException | InputMismatchException e){
            System.out.println("Błędny format pliku.");
            return false;
        }
        return true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String[][] getTemp(){
        return temp;
    }



    public void printGrid(){
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.printf("%s ",temp[i][j]);
            }
            System.out.printf("%n");
        }
    }

    public boolean readFile() {
        for (int k = 0; k < x; k++){
            Arrays.fill(temp[k], "E");
        }
        try {
            Scanner in = new Scanner(Paths.get(inName));
            String t;
            in.nextLine();
            int xTemp;
            int yTemp;

            while (in.hasNext()) {
                t=in.next();
                switch (t) {
                    case "Horizontalline":
                        t = in.next();

                        try {
                            xTemp = Integer.parseInt(t);
                            t = in.next();
                            yTemp = Integer.parseInt(t);

                            if(yTemp <= y-5){
                                for(int i = 0; i < 5; i ++)
                                    temp[xTemp][yTemp+i] = "C";
                            }
                        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                            System.out.println("Niepoprawna definicja współrzędnych w pliku wejściowym.");
                            return false;
                        }
                        break;
                    case "Verticalline":
                        t = in.next();

                        try {
                            xTemp = Integer.parseInt(t);
                            t = in.next();
                            yTemp = Integer.parseInt(t);

                            if(xTemp <= x-5){
                                for(int i = 0; i < 5; i ++)
                                    temp[xTemp+i][yTemp] = "C";
                            }
                        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                            System.out.println("Niepoprawna definicja współrzędnych w pliku wejściowym.");
                            return false;
                        }
                        break;
                    case "Horizontalgate":
                        t = in.next();

                        try {
                            xTemp = Integer.parseInt(t);
                            t = in.next();
                            yTemp = Integer.parseInt(t);

                            temp[xTemp-1][yTemp+1] = "C";
                            temp[xTemp-1][yTemp+2] = "C";
                            temp[xTemp][yTemp] = "C";
                            temp[xTemp][yTemp+1] = "C";
                            temp[xTemp][yTemp+3] = "C";
                            temp[xTemp+1][yTemp+1] = "C";
                            temp[xTemp+1][yTemp+2] = "C";

                        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                            System.out.println("Niepoprawna definicja współrzędnych w pliku wejściowym.");
                            return false;
                        }
                        break;
                    case "Verticalgate":
                        t = in.next();

                        try {
                            xTemp = Integer.parseInt(t);
                            t = in.next();
                            yTemp = Integer.parseInt(t);

                            temp[xTemp][yTemp] = "C";
                            temp[xTemp+1][yTemp-1] = "C";
                            temp[xTemp+1][yTemp] = "C";
                            temp[xTemp+1][yTemp+1] = "C";
                            temp[xTemp+2][yTemp-1] = "C";
                            temp[xTemp+2][yTemp+1] = "C";
                            temp[xTemp+3][yTemp] = "C";

                        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                            System.out.println("Niepoprawna definicja współrzędnych w pliku wejściowym.");
                            return false;
                        }
                        break;
                    case "Empty":
                        break;
                    case "Head":
                        t = in.next();
                        try {
                            xTemp = Integer.parseInt(t);
                            t = in.next();
                            yTemp = Integer.parseInt(t);

                            temp[xTemp][yTemp] = "H";
                        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                            System.out.println("Niepoprawna definicja współrzędnych w pliku wejściowym.");
                            return false;
                        }
                        break;

                    case "Conductor":
                        t = in.next();

                        try {
                            xTemp = Integer.parseInt(t);
                            t = in.next();
                            yTemp = Integer.parseInt(t);

                            temp[xTemp][yTemp] = "C";
                        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                            System.out.println("Niepoprawna definicja współrzędnych w pliku wejściowym.");
                            return false;
                        }
                        break;

                    case "Tail":
                        t = in.next();

                        try {
                            xTemp = Integer.parseInt(t);
                            t = in.next();
                            yTemp = Integer.parseInt(t);

                            temp[xTemp][yTemp] = "T";
                        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                            System.out.println("Niepoprawna definicja współrzędnych w pliku wejściowym.");
                            return false;
                        }
                        break;
                    default: {
                        System.out.println("Plik zawiera niepoprawne dane.");
                        return false;
                    }
                }
            }
        } catch(IOException e){
            System.out.println("Plik z konfiguracją wejściową nie został znaleziony. Upewnij się, że znajduje się on w odpowiednim folderze.");
            return false;
        }

        return true;
    }
}


