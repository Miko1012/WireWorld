package Tests;

import logic.*;

public class RulesTest {

    public void countHeadNeighboursTest1(){
        Rules test = new Rules();
        System.out.println("Test 8. Spodziewana wartość: 2.");

        Cell[][] grid = {   {new Conductor(), new Head(), new Head(), new Conductor(), new Empty()},
                            {new Head(), new Empty(), new Head(), new Empty(), new Conductor()},
                            {new Conductor(), new Conductor(), new Conductor(), new Conductor(), new Conductor()},
                            {new Empty(), new Empty(), new Conductor(),new Conductor(),new Empty()},
                            {new Empty(), new Empty(), new Empty(), new Empty(), new Empty()}};


        int n = test.countHeadNeighbours(0,0,grid,5,5);
        System.out.println("N = " + n);
        if(n == 2){
            System.out.println("Test 8 zakończony pomyślnie.");
        }



    }
}
