package gameoflife;

import java.util.ArrayList;

public class NextGeneration {

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

    static boolean CheckValidCell(int x, int y, int row, int col)
    {
        if(x>= 0 && x< row && y>= 0 && y<col){
            return true;
        }
        else{
            return false;
        }
    }

    static ArrayList<ArrayList<Integer>> GenerateDeepCopyOfArrayList(ArrayList<ArrayList<Integer>> grid, ArrayList<ArrayList<Integer>> futureCopyGrid)
    {
        for(int index = 0; index < grid.size(); index++) {
            futureCopyGrid.add(new ArrayList<Integer>(grid.get(index)));
        }
        return futureCopyGrid;
    }

    static ArrayList<ArrayList<Integer>> CalculateNextGenerationCells(ArrayList<ArrayList<Integer>> future, ArrayList<ArrayList<Integer>> futureCopy)
    {
        for (int l = 0; l < future.size(); l++)
        {
            for (int m = 0; m < future.get(l).size(); m++)
            {
                int aliveNeighbours = CountAliveNeighbours(futureCopy, l, m);
                if ((futureCopy.get(l).get(m) == 1) && (aliveNeighbours < 2))
                    future.get(l).set(m, 0);

                else if ((futureCopy.get(l).get(m) == 1) && (aliveNeighbours > 3))
                    future.get(l).set(m, 0);

                else if ((futureCopy.get(l).get(m) == 0) && (aliveNeighbours == 3))
                    future.get(l).set(m, 1);

                else
                    future.get(l).set(m, futureCopy.get(l).get(m));
            }
        }
        return future;
    }

    static ArrayList<ArrayList<Integer>> nextGeneration(ArrayList<ArrayList<Integer>> grid, int M, int N)
    {
        ArrayList<ArrayList<Integer>> futureGrid;
        ArrayList<ArrayList<Integer>> futureCopyGrid = new ArrayList<>();
        futureGrid = ExpandGrid.ExpandGrid(grid);
        futureCopyGrid = GenerateDeepCopyOfArrayList(futureGrid, futureCopyGrid);
        futureGrid = CalculateNextGenerationCells(futureGrid,futureCopyGrid);
        futureGrid = CompressGrid.DeleteDeadRows(futureGrid);

        return futureGrid;
    }

}
