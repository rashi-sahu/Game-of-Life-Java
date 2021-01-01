package gameoflife;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static int blah() {
        return 5;
    }
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
        System.out.println("Original Generation");
        ArrayList<ArrayList<Integer>> nextGen = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < grid.size(); i++)
        {
            ArrayList<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j < grid.get(i).length(); j++)
            {
                if (grid.get(i).charAt(j)=='0') {
                    System.out.print(".");
                }
                else{
                    System.out.print("*");
                }
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
            nextGen = nextGeneration(nextGen, nextGen.size(), nextGen.get(0).size());
            t--;

            Thread.sleep(1000);
        }
        System.out.println("blah blah");
    }

    static ArrayList<ArrayList<Integer>> nextGeneration(ArrayList<ArrayList<Integer>> grid, int M, int N)
    {
        ArrayList<ArrayList<Integer>> future = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> futureCopyGrid = new ArrayList<ArrayList<Integer>>();
        future = ExpandGrid(grid,M,N);
        for(int index = 0; index < future.size(); index++) {
            futureCopyGrid.add(new ArrayList<Integer>(future.get(index)));
        }
        for (int l = 0; l < future.size(); l++)
        {
            for (int m = 0; m < future.get(l).size(); m++)
            {
                int aliveNeighbours = CountAliveNeighbours(futureCopyGrid, l, m);
                if ((futureCopyGrid.get(l).get(m) == 1) && (aliveNeighbours < 2))
                    future.get(l).set(m, 0);

                else if ((futureCopyGrid.get(l).get(m) == 1) && (aliveNeighbours > 3))
                    future.get(l).set(m, 0);

                else if ((futureCopyGrid.get(l).get(m) == 0) && (aliveNeighbours == 3))
                    future.get(l).set(m, 1);

                else
                    future.get(l).set(m, futureCopyGrid.get(l).get(m));
            }
        }
        future = DeleteDeadRows(future);
        PrintGrid(future);

        return future;
    }
    public static void clearScreen() throws IOException, InterruptedException  {
        System.out.println("\033[2J\033[1;1H");
    }

    static int CountAliveNeighbours(ArrayList<ArrayList<Integer>> grid, int x, int y)
    {
        int aliveNeighbours = 0;
        int row = grid.size();
        int column = grid.get(0).size();
        if (CheckValidCell(x - 1, y - 1, row, column) && grid.get(x - 1).get(y - 1) == 1)
            aliveNeighbours += 1;
        if (CheckValidCell(x - 1, y, row, column) && grid.get(x - 1).get(y) == 1)
            aliveNeighbours += 1;
        if (CheckValidCell(x - 1, y + 1, row, column) && grid.get(x - 1).get(y + 1) == 1)
            aliveNeighbours += 1;
        if (CheckValidCell(x, y - 1, row, column) && grid.get(x).get(y - 1) == 1)
            aliveNeighbours += 1;
        if (CheckValidCell(x, y + 1, row, column) && grid.get(x).get(y + 1) == 1)
            aliveNeighbours += 1;
        if (CheckValidCell(x + 1, y - 1, row, column) && grid.get(x + 1).get(y - 1) == 1)
            aliveNeighbours += 1;
        if (CheckValidCell(x + 1, y, row, column) && grid.get(x + 1).get(y) == 1)
            aliveNeighbours += 1;
        if (CheckValidCell(x + 1, y + 1, row, column) && grid.get(x + 1).get(y + 1) == 1)
            aliveNeighbours += 1;
        return aliveNeighbours;
    }
    static int CheckCornerCell(ArrayList<ArrayList<Integer>> grid, int l, int m)
    {
        if(l==0 || m==0 || l== grid.size()-1 || m== grid.get(0).size() - 1){
            return 1;
        }
        else{
            return 0;
        }
    }
    static boolean CheckValidCell(int x, int y, int row, int col)
    {
        if(x>= 0 && x< row && y>= 0 && y<col){
            return true;
        }
        else{
            return false;
        }
    }
    static ArrayList<ArrayList<Integer>> ExpandGrid(ArrayList<ArrayList<Integer>> grid, int M, int N)
    {
        ArrayList<ArrayList<Integer>> expandedGrid = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < M+2; i++)
        {
            ArrayList<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j < N+2; j++)
            {
                row.add(0);
            }
            expandedGrid.add(row);
        }
        for (int i = 1; i < M+1; i++)
        {
            for (int j = 1; j < N+1; j++)
            {
                expandedGrid.get(i).set(j, grid.get(i-1).get(j-1));
            }
        }
        return expandedGrid;
    }
    static ArrayList<ArrayList<Integer>> DeleteDeadRows(ArrayList<ArrayList<Integer>> grid)
    {
        ArrayList<ArrayList<Integer>> finalGrid = new ArrayList<ArrayList<Integer>>();
        finalGrid = DeleteFromTop(grid);
        finalGrid = DeleteFromBottom(finalGrid);
        finalGrid = DeleteFromLeft(finalGrid);
        finalGrid = DeleteFromRight(finalGrid);
        return finalGrid;
    }
    static ArrayList<ArrayList<Integer>> GenerateDeepCopyOfArrayList(ArrayList<ArrayList<Integer>> grid, ArrayList<ArrayList<Integer>> futureCopyGrid)
    {
        for(int index = 0; index < grid.size(); index++) {
            futureCopyGrid.add(new ArrayList<Integer>(grid.get(index)));
        }
        return futureCopyGrid;
    }
    static ArrayList<ArrayList<Integer>> DeleteFromTop(ArrayList<ArrayList<Integer>> grid)
    {
        ArrayList<ArrayList<Integer>> futureCopyGrid = new ArrayList<ArrayList<Integer>>();
        futureCopyGrid = GenerateDeepCopyOfArrayList(grid, futureCopyGrid);

        for(int i = 0;i < grid.size();i++){
            for (int j = 0; j < grid.get(i).size(); j++)
            {
                if(grid.get(i).get(j) == 1)
                    return futureCopyGrid;
            }
            futureCopyGrid.remove(0);
        }
        return futureCopyGrid;
    }
    static ArrayList<ArrayList<Integer>> DeleteFromBottom(ArrayList<ArrayList<Integer>> grid)
    {
        ArrayList<ArrayList<Integer>> futureCopyGrid = new ArrayList<ArrayList<Integer>>();
        futureCopyGrid = GenerateDeepCopyOfArrayList(grid, futureCopyGrid);

        for(int i = grid.size()-1;i >=0;i--){
            for (int j = grid.get(i).size() - 1; j >=0 ; j--)
            {
                if(grid.get(i).get(j) == 1)
                    return futureCopyGrid;
            }
            futureCopyGrid.remove(futureCopyGrid.size()-1);
        }
        return futureCopyGrid;
    }
    static ArrayList<ArrayList<Integer>> DeleteFromLeft(ArrayList<ArrayList<Integer>> grid)
    {
        ArrayList<ArrayList<Integer>> futureCopyGrid = new ArrayList<ArrayList<Integer>>();
        futureCopyGrid = GenerateDeepCopyOfArrayList(grid, futureCopyGrid);

        int column = 0;
        outerloop:
        for(int j = 0;j < grid.get(0).size();j++){
            for (int i = 0; i < grid.size(); i++)
            {
                if(grid.get(i).get(j) == 1){
                    column = j;
                    break outerloop;
                }
            }
        }
        for(int j = 0;j < column;j++){
            for (int i = 0; i < grid.size(); i++)
            {
                futureCopyGrid.get(i).remove(0);
            }
        }
        return futureCopyGrid;
    }
    static ArrayList<ArrayList<Integer>> DeleteFromRight(ArrayList<ArrayList<Integer>> grid)
    {
        ArrayList<ArrayList<Integer>> futureCopyGrid = new ArrayList<ArrayList<Integer>>();
        futureCopyGrid = GenerateDeepCopyOfArrayList(grid, futureCopyGrid);

        int column = 0;
        outerloop:
        for(int j = grid.get(0).size() - 1;j >=0 ;j--){
            for (int i = grid.size() - 1; i >= 0; i--)
            {
                if(grid.get(i).get(j) == 1){
                    column = j;
                    break outerloop;
                }
            }
        }
        for(int j = grid.get(0).size() - 1;j > column ;j--){
            for (int i = grid.size() - 1; i >= 0; i--)
            {
                futureCopyGrid.get(i).remove(futureCopyGrid.get(0).size()-1);
            }
        }
        return futureCopyGrid;
    }
    static void PrintGrid(ArrayList<ArrayList<Integer>> grid)
    {
        System.out.println("Next Generation");
        for (int i = 0; i < grid.size(); i++)
        {
            for (int j = 0; j < grid.get(i).size(); j++)
            {
                if (grid.get(i).get(j)== 0)
                    System.out.print(".");
                else
                    System.out.print("*");
            }
            System.out.println();
        }

//        try{
//            clearScreen();
//        }
//        catch (IOException e) {
//            //log/handle the exception
//        } catch (InterruptedException e) {
//            //log/handle the exception
//        }
    }
}
