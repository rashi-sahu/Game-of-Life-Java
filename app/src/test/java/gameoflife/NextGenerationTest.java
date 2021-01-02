package gameoflife;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class NextGenerationTest {

    @Test public void CountAliveNeighbours1() {
        ArrayList<ArrayList<Integer>> inputArray = new ArrayList<>();
        inputArray.add(new ArrayList<>(Arrays.asList(0,0,0,0,0)));
        inputArray.add(new ArrayList<>(Arrays.asList(0,0,1,0,0)));
        inputArray.add(new ArrayList<>(Arrays.asList(0,0,1,0,0)));
        inputArray.add(new ArrayList<>(Arrays.asList(0,0,1,0,0)));
        inputArray.add(new ArrayList<>(Arrays.asList(0,0,0,0,0)));

        assertEquals(0, NextGeneration.CountAliveNeighbours(inputArray,4,4));
        assertEquals(2, NextGeneration.CountAliveNeighbours(inputArray,2,2));
        assertEquals(1, NextGeneration.CountAliveNeighbours(inputArray,1,2));
        assertEquals(2, NextGeneration.CountAliveNeighbours(inputArray,1,3));
        assertEquals(3, NextGeneration.CountAliveNeighbours(inputArray,2,1));
    }

    @Test public void CountAliveNeighbours2() {
        ArrayList<ArrayList<Integer>> inputArray = new ArrayList<>();

        assertEquals(0, NextGeneration.CountAliveNeighbours(inputArray,0,0));
    }

    @Test public void CheckValidCell1() {

        assertEquals(true, NextGeneration.CheckValidCell(0,0,5,6));
        assertEquals(false, NextGeneration.CheckValidCell(8,0,5,6));
        assertEquals(false, NextGeneration.CheckValidCell(6,0,5,6));
    }

    @Test public void GenerateDeepCopyOfArrayList1() {
        ArrayList<ArrayList<Integer>> inputArray = new ArrayList<>();
        ArrayList<ArrayList<Integer>> copyGrid = new ArrayList<>();
        inputArray.add(new ArrayList<>(Arrays.asList(0,0,0,1,1)));
        inputArray.add(new ArrayList<>(Arrays.asList(0,0,1,0,0)));

        ArrayList<ArrayList<Integer>> expectedArray = new ArrayList<>();
        expectedArray.add(new ArrayList<>(Arrays.asList(0,0,0,1,1)));
        expectedArray.add(new ArrayList<>(Arrays.asList(0,0,1,0,0)));

        assertEquals(expectedArray, NextGeneration.GenerateDeepCopyOfArrayList(inputArray,copyGrid));
    }

    @Test public void CalculateNextGenerationCells1() {
        ArrayList<ArrayList<Integer>> inputArray = new ArrayList<>();
        ArrayList<ArrayList<Integer>> copyGrid = new ArrayList<>();
        inputArray.add(new ArrayList<>(Arrays.asList(1,0,0,0,1)));
        inputArray.add(new ArrayList<>(Arrays.asList(0,0,1,0,0)));
        inputArray.add(new ArrayList<>(Arrays.asList(0,1,1,0,0)));
        inputArray.add(new ArrayList<>(Arrays.asList(0,1,1,0,0)));

        copyGrid = NextGeneration.GenerateDeepCopyOfArrayList(inputArray, copyGrid);

        ArrayList<ArrayList<Integer>> expectedArray = new ArrayList<>();
        expectedArray.add(new ArrayList<>(Arrays.asList(0,0,0,0,0)));
        expectedArray.add(new ArrayList<>(Arrays.asList(0,0,1,1,0)));
        expectedArray.add(new ArrayList<>(Arrays.asList(0,0,0,1,0)));
        expectedArray.add(new ArrayList<>(Arrays.asList(0,1,1,0,0)));

        assertEquals(expectedArray, NextGeneration.CalculateNextGenerationCells(inputArray, copyGrid));
    }

    @Test public void nextGenerationTest1() {
        ArrayList<ArrayList<Integer>> inputArray = new ArrayList<ArrayList<Integer>>();
        inputArray.add(new ArrayList<>(Arrays.asList(0,0,0,0,0)));
        inputArray.add(new ArrayList<>(Arrays.asList(0,0,1,0,0)));
        inputArray.add(new ArrayList<>(Arrays.asList(0,0,1,0,0)));
        inputArray.add(new ArrayList<>(Arrays.asList(0,0,1,0,0)));
        inputArray.add(new ArrayList<>(Arrays.asList(0,0,0,0,0)));

        ArrayList<ArrayList<Integer>> expectedArray = new ArrayList<ArrayList<Integer>>();
        expectedArray.add(new ArrayList<>(Arrays.asList(1,1,1)));

        assertEquals(expectedArray, NextGeneration.nextGeneration(inputArray,5,5));
    }

    @Test public void nextGenerationTest2() {
        ArrayList<ArrayList<Integer>> inputArray = new ArrayList<ArrayList<Integer>>();

        ArrayList<ArrayList<Integer>> expectedArray = new ArrayList<ArrayList<Integer>>();

        assertEquals(expectedArray, NextGeneration.nextGeneration(inputArray,0,0));
    }
}
