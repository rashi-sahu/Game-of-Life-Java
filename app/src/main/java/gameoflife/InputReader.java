package gameoflife;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class InputReader {
    static ArrayList<ArrayList<Integer>> ReadInputFromFile()
    {
        Scanner s;
        try{
            s = new Scanner(new File("/home/rashi/Game-of-Life-gradle/app/src/main/java/gameoflife/Input.txt"));
        }
        catch (FileNotFoundException ex)
        {
            System.out.println(ex.getMessage());
            return new ArrayList<>();
        }
        ArrayList<String> grid = new ArrayList<>();
        while (s.hasNextLine()){
            grid.add(s.nextLine());
        }
        s.close();
        ArrayList<ArrayList<Integer>> nextGen = new ArrayList<>();
        for (int i = 0; i < grid.size(); i++)
        {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < grid.get(i).length(); j++)
            {
                row.add(Character.getNumericValue(grid.get(i).charAt(j)));
            }
            nextGen.add(row);
        }

        return nextGen;
    }
}
