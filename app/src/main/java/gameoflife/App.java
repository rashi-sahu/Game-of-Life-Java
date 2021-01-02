package gameoflife;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws InterruptedException {
        Scanner s;
        try{
            s = new Scanner(new File("/home/rashi/Game-of-Life-gradle/app/src/main/java/gameoflife/Input.txt"));
            System.out.println(s);
        }
        catch (FileNotFoundException ex)
        {
            System.out.println(ex.getMessage());
            s = new Scanner(System.in);
        }
        ArrayList<String> grid = new ArrayList<String>();
        while (s.hasNextLine()){
            System.out.println("reading line");
            grid.add(s.nextLine());
        }
        s.close();
        ArrayList<ArrayList<Integer>> nextGen = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < grid.size(); i++)
        {
            ArrayList<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j < grid.get(i).length(); j++)
            {
                row.add(Character.getNumericValue(grid.get(i).charAt(j)));
            }
            nextGen.add(row);
            System.out.println();
        }
        System.out.println();
        int t=500000;
        while(t>0){
            try{
                clearScreen();
            }
            catch (IOException e) {
                //log/handle the exception
            } catch (InterruptedException e) {
                //log/handle the exception
            }
            nextGen = NextGeneration.nextGeneration(nextGen, nextGen.size(), nextGen.get(0).size());
            PrintGrid(nextGen);

            t--;

            Thread.sleep(1000);
        }
    }


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
}
