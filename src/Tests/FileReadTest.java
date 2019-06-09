package Tests;

import logic.*;


public class FileReadTest {

    public void testSetSize1() {
        System.out.println("Testowanie klasy FileRead:");
        System.out.println();

        FileRead test = new FileRead("plikitestowe/testSetSizeIncorrect1.txt");
        System.out.println("Test 1. Spodziewana wartość: \"Niepoprawne wymiary siatki\".");
        if (!test.setSize()) {
            System.out.println("Test 1. zakończono pomyślnie.");
            System.out.println();
        }
    }

    public void testSetSize2(){
        FileRead test = new FileRead("plikitestowe/testSetSizeIncorrect2.txt");
        System.out.println("Test 2. Spodziewana wartość: \"Niepoprawne wymiary siatki\".");
        if (!test.setSize()) {
            System.out.println("Test 2. zakończono pomyślnie.");
            System.out.println();
        }

    }

    public void testSetSize3(){
        FileRead test = new FileRead("plikitestowe/testSetSizeCorrect1.txt");
        if (test.setSize()) {
            System.out.println("Test 3. Zakończono pomyślnie.");
            System.out.println("Wczytane wymiary siatki to: " + test.getX() + " x " + test.getY());
            System.out.println();
        }

    }

    public void testReadFile1(){
        FileRead test = new FileRead("plikitestowe/testReadFileIncorrect1.txt", 5, 5);
        System.out.println("Test 4. Spodziewana wartość: \"Niepoprawna definicja współrzędnych\".");
        if(!test.readFile()) {
            System.out.println("Test 4. zakończony pomyślnie.");
        }
        System.out.println();

    }

    public void testReadFile2(){
        FileRead test = new FileRead("plikitestowe/testReadFileIncorrect2.txt", 10, 10);
        System.out.println("Test 5. Spodziewana wartość: \"Plik zawiera niepoprawne dane.\".");
        if(!test.readFile()){
            System.out.println("Test 5. zakończony pomyślnie.");
        }
        System.out.println();

    }

    public void testReadFile3(){
        FileRead test = new FileRead("plikitestowe/testReadFileCorrect1.txt", 10, 10);
        if(test.readFile()){
            System.out.println("Test 6. zakończony pomyślnie.");
        }
        System.out.println();

    }

    public void testReadFile4() {
        FileRead test = new FileRead("plikitestowe/testReadFileCorrect2.txt", 10, 10);
        if (test.readFile()) {
            System.out.println("Test 7. zakończony pomyślnie.");
        }
        System.out.println();
    }







}
