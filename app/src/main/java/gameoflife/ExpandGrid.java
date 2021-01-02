package gameoflife;

import java.util.ArrayList;

public class ExpandGrid {
    static ArrayList<ArrayList<Integer>> ExpandGrid(ArrayList<ArrayList<Integer>> grid)
    {
        if(grid.size()>0) {
            ArrayList<ArrayList<Integer>> expandedGrid = new ArrayList<>();
            for (int i = 0; i < grid.size() + 2; i++) {
                ArrayList<Integer> row = new ArrayList<>();
                for (int j = 0; j < grid.get(0).size() + 2; j++) {
                    row.add(0);
                }
                expandedGrid.add(row);
            }
            System.out.println(expandedGrid);
            for (int i = 1; i < expandedGrid.size() - 1; i++) {
                for (int j = 1; j < expandedGrid.get(0).size() - 1; j++) {
                    expandedGrid.get(i).set(j, grid.get(i - 1).get(j - 1));
                }
            }
            System.out.println("ok");
            return expandedGrid;
        }
        else{
            return new ArrayList<>();
        }
    }
}
