package gameoflife;

import java.util.ArrayList;

public class CompressGrid {
    static ArrayList<ArrayList<Integer>> GenerateDeepCopyOfArrayList(ArrayList<ArrayList<Integer>> grid, ArrayList<ArrayList<Integer>> futureCopyGrid)
    {
        for(int index = 0; index < grid.size(); index++) {
            futureCopyGrid.add(new ArrayList<Integer>(grid.get(index)));
        }
        return futureCopyGrid;
    }

    static ArrayList<ArrayList<Integer>> DeleteFromTop(ArrayList<ArrayList<Integer>> grid)
    {
        ArrayList<ArrayList<Integer>> futureCopyGrid = new ArrayList<>();
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
        ArrayList<ArrayList<Integer>> futureCopyGrid = new ArrayList<>();
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
        ArrayList<ArrayList<Integer>> futureCopyGrid = new ArrayList<>();
        futureCopyGrid = GenerateDeepCopyOfArrayList(grid, futureCopyGrid);
        if(grid.size()>0) {
            int column = 0;
            outerloop:
            for (int j = 0; j < grid.get(0).size(); j++) {
                for (int i = 0; i < grid.size(); i++) {
                    if (grid.get(i).get(j) == 1) {
                        column = j;
                        break outerloop;
                    }
                }
                if(j==3){
                    return new ArrayList<>();
                }
            }

            for (int j = 0; j < column; j++) {
                for (int i = 0; i < grid.size(); i++) {
                    futureCopyGrid.get(i).remove(0);
                }
            }
            return futureCopyGrid;
        }
        else{
            return new ArrayList<>();
        }
    }
    static ArrayList<ArrayList<Integer>> DeleteFromRight(ArrayList<ArrayList<Integer>> grid)
    {
        ArrayList<ArrayList<Integer>> futureCopyGrid = new ArrayList<>();
        futureCopyGrid = GenerateDeepCopyOfArrayList(grid, futureCopyGrid);
        if(grid.size()>0) {
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
                if(j==0){
                    return new ArrayList<>();
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
        else{
            return new ArrayList<>();
        }
    }

    static ArrayList<ArrayList<Integer>> DeleteDeadRows(ArrayList<ArrayList<Integer>> grid)
    {
        ArrayList<ArrayList<Integer>> finalGrid;
        finalGrid = CompressGrid.DeleteFromTop(grid);
        finalGrid = CompressGrid.DeleteFromBottom(finalGrid);
        finalGrid = CompressGrid.DeleteFromLeft(finalGrid);
        finalGrid = CompressGrid.DeleteFromRight(finalGrid);
        return finalGrid;
    }
}
