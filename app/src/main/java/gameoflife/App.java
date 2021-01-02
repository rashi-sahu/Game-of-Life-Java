package gameoflife;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void clearScreen() throws IOException, InterruptedException  {
        System.out.println("\033[2J\033[1;1H");
    }

    static void PrintGrid(ArrayList<ArrayList<Integer>> grid)
    {
        if(grid.size()>0) {
            for (int i = 0; i < grid.size(); i++) {
                for (int j = 0; j < grid.get(i).size(); j++) {
                    if (grid.get(i).get(j) == 0)
                        System.out.print(".");
                    else
                        System.out.print("*");
                }
                System.out.println();
            }
        }
        else {
            return;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayList<ArrayList<Integer>> nextGen = InputReader.ReadInputFromFile();
        if(nextGen.size()==0){
            System.exit(0);
        }
        int t=500000;
        while(t>0){
            try{
                clearScreen();
            }
            catch (IOException | InterruptedException e) {
                //log/handle the exception
            }
            nextGen = NextGeneration.nextGeneration(nextGen, nextGen.size(), nextGen.get(0).size());
            if(nextGen.size()==0){
                System.exit(0);
            }
            PrintGrid(nextGen);

            t--;

            Thread.sleep(1000);
        }
    }

}
