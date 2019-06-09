import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.String;

public class FileRead {
    private String inName;
    private int x;
    private int y;
    private String[][] temp;

    public FileRead(Config config) {
        this.inName = config.getInFile();
    }

    public boolean setSize(){
        try {
            Scanner in = new Scanner(Paths.get(inName));
        }
        catch (IOException e){
            System.out.println("Nie znaleziono pliku.");
            return false;
        }

        try {
            Scanner in = new Scanner(Paths.get(inName));
            this.x = in.nextInt();
            this.y = in.nextInt();
            this.temp = new String[x][y];
        } catch (IOException e){
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

    public String getState(int x, int y){
        return temp[x][y];
    }

    public void printGrid(){
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.printf("%s ",temp[i][j]);
            }
            System.out.printf("%n");
        }
    }

    public int readFileWW() {
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
                        } catch (NumberFormatException e) {
                            System.out.println("Niepoprawna definicja współrzędnych w pliku wejściowym.");
                            return 1;
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
                        } catch (NumberFormatException e) {
                            System.out.println("Niepoprawna definicja współrzędnych w pliku wejściowym.");
                            return 1;
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
                            temp[xTemp][yTemp+2] = "C";
                            temp[xTemp+1][yTemp+1] = "C";
                            temp[xTemp+1][yTemp+2] = "C";

                        } catch (NumberFormatException e) {
                            System.out.println("Niepoprawna definicja współrzędnych w pliku wejściowym.");
                            return 1;
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
                            temp[xTemp+2][yTemp] = "C";
                            temp[xTemp+2][yTemp+2] = "C";
                            temp[xTemp+3][yTemp] = "C";

                        } catch (NumberFormatException e) {
                            System.out.println("Niepoprawna definicja współrzędnych w pliku wejściowym.");
                            return 1;
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
                        } catch (NumberFormatException e) {
                            System.out.println("Niepoprawna definicja współrzędnych w pliku wejściowym.");
                            return 1;
                        }
                        break;

                    case "Conductor":
                        t = in.next();

                        try {
                            xTemp = Integer.parseInt(t);
                            t = in.next();
                            yTemp = Integer.parseInt(t);

                            temp[xTemp][yTemp] = "C";
                        } catch (NumberFormatException e) {
                            System.out.println("Niepoprawna definicja współrzędnych w pliku wejściowym.");
                            return 1;
                        }
                        break;

                    case "Tail":
                        t = in.next();

                        try {
                            xTemp = Integer.parseInt(t);
                            t = in.next();
                            yTemp = Integer.parseInt(t);

                            temp[xTemp][yTemp] = "T";
                        } catch (NumberFormatException e) {
                            System.out.println("Niepoprawna definicja współrzędnych w pliku wejściowym.");
                            return 1;
                        }
                        break;
                    default:
                        System.out.println("Plik zawiera niepoprawne dane.");
                        return 1;
                }
            }
        } catch(IOException e){
            System.out.println("Plik z konfiguracją wejściową nie został znaleziony. Upewnij się, że znajduje się on w odpowiednim folderze.");
        }

        return 0;
    }
}

