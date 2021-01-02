package gameoflife;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ExpandGridTest {
    @Test
    public void ExpandGrid1() {
        ArrayList<ArrayList<Integer>> inputArray = new ArrayList<>();
        inputArray.add(new ArrayList<>(Arrays.asList(0,0)));
        inputArray.add(new ArrayList<>(Arrays.asList(0,1)));

        ArrayList<ArrayList<Integer>> expectedArray = new ArrayList<ArrayList<Integer>>();
        expectedArray.add(new ArrayList<>(Arrays.asList(0,0,0,0)));
        expectedArray.add(new ArrayList<>(Arrays.asList(0,0,0,0)));
        expectedArray.add(new ArrayList<>(Arrays.asList(0,0,1,0)));
        expectedArray.add(new ArrayList<>(Arrays.asList(0,0,0,0)));

        assertEquals(expectedArray, ExpandGrid.ExpandGrid(inputArray));
    }

    @Test public void ExpandGrid2() {
        ArrayList<ArrayList<Integer>> inputArray = new ArrayList<>();

        ArrayList<ArrayList<Integer>> expectedArray = new ArrayList<>();

        assertEquals(expectedArray, ExpandGrid.ExpandGrid(inputArray));
    }
}
