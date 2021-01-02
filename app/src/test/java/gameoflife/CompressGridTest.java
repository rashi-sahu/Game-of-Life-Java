package gameoflife;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class CompressGridTest {

    @Test public void DeleteFromTop1() {
        ArrayList<ArrayList<Integer>> inputArray = new ArrayList<>();
        inputArray.add(new ArrayList<>(Arrays.asList(0,0,0,0,0)));
        inputArray.add(new ArrayList<>(Arrays.asList(0,0,0,0,0)));
        inputArray.add(new ArrayList<>(Arrays.asList(0,0,1,0,0)));
        inputArray.add(new ArrayList<>(Arrays.asList(0,0,1,0,0)));
        inputArray.add(new ArrayList<>(Arrays.asList(0,0,0,0,0)));

        ArrayList<ArrayList<Integer>> expectedArray = new ArrayList<>();
        expectedArray.add(new ArrayList<>(Arrays.asList(0,0,1,0,0)));
        expectedArray.add(new ArrayList<>(Arrays.asList(0,0,1,0,0)));
        expectedArray.add(new ArrayList<>(Arrays.asList(0,0,0,0,0)));

        assertEquals(expectedArray, CompressGrid.DeleteFromTop(inputArray));
    }

    @Test public void DeleteFromTop2() {
        ArrayList<ArrayList<Integer>> inputArray = new ArrayList<>();

        ArrayList<ArrayList<Integer>> expectedArray = new ArrayList<>();

        assertEquals(expectedArray, CompressGrid.DeleteFromTop(inputArray));
    }

    @Test public void DeleteFromTop3() {
        ArrayList<ArrayList<Integer>> inputArray = new ArrayList<>();
        inputArray.add(new ArrayList<>(Arrays.asList(0,0,0,0)));
        inputArray.add(new ArrayList<>(Arrays.asList(0,0,0,0)));

        ArrayList<ArrayList<Integer>> expectedArray = new ArrayList<>();

        assertEquals(expectedArray, CompressGrid.DeleteFromTop(inputArray));
    }

    @Test public void DeleteFromBottom1() {
        ArrayList<ArrayList<Integer>> inputArray = new ArrayList<>();
        inputArray.add(new ArrayList<>(Arrays.asList(0,0,0,0,0)));
        inputArray.add(new ArrayList<>(Arrays.asList(0,0,0,0,0)));
        inputArray.add(new ArrayList<>(Arrays.asList(0,0,1,0,0)));
        inputArray.add(new ArrayList<>(Arrays.asList(0,0,1,0,0)));
        inputArray.add(new ArrayList<>(Arrays.asList(0,0,0,0,0)));
        inputArray.add(new ArrayList<>(Arrays.asList(0,0,0,0,0)));
        inputArray.add(new ArrayList<>(Arrays.asList(0,0,0,0,0)));

        ArrayList<ArrayList<Integer>> expectedArray = new ArrayList<>();
        expectedArray.add(new ArrayList<>(Arrays.asList(0,0,0,0,0)));
        expectedArray.add(new ArrayList<>(Arrays.asList(0,0,0,0,0)));
        expectedArray.add(new ArrayList<>(Arrays.asList(0,0,1,0,0)));
        expectedArray.add(new ArrayList<>(Arrays.asList(0,0,1,0,0)));

        assertEquals(expectedArray, CompressGrid.DeleteFromBottom(inputArray));
    }

    @Test public void DeleteFromBottom2() {
        ArrayList<ArrayList<Integer>> inputArray = new ArrayList<>();

        ArrayList<ArrayList<Integer>> expectedArray = new ArrayList<>();

        assertEquals(expectedArray, CompressGrid.DeleteFromBottom(inputArray));
    }

    @Test public void DeleteFromBottom3() {
        ArrayList<ArrayList<Integer>> inputArray = new ArrayList<>();
        inputArray.add(new ArrayList<>(Arrays.asList(0,0,0,0)));
        inputArray.add(new ArrayList<>(Arrays.asList(0,0,0,0)));

        ArrayList<ArrayList<Integer>> expectedArray = new ArrayList<>();

        assertEquals(expectedArray, CompressGrid.DeleteFromBottom(inputArray));
    }

    @Test public void DeleteFromLeft1() {
        ArrayList<ArrayList<Integer>> inputArray = new ArrayList<>();
        inputArray.add(new ArrayList<>(Arrays.asList(0,0,0,0,0)));
        inputArray.add(new ArrayList<>(Arrays.asList(0,0,0,0,0)));
        inputArray.add(new ArrayList<>(Arrays.asList(0,0,1,0,0)));
        inputArray.add(new ArrayList<>(Arrays.asList(0,0,1,0,0)));
        inputArray.add(new ArrayList<>(Arrays.asList(0,0,0,0,0)));

        ArrayList<ArrayList<Integer>> expectedArray = new ArrayList<>();
        expectedArray.add(new ArrayList<>(Arrays.asList(0,0,0)));
        expectedArray.add(new ArrayList<>(Arrays.asList(0,0,0)));
        expectedArray.add(new ArrayList<>(Arrays.asList(1,0,0)));
        expectedArray.add(new ArrayList<>(Arrays.asList(1,0,0)));
        expectedArray.add(new ArrayList<>(Arrays.asList(0,0,0)));

        assertEquals(expectedArray, CompressGrid.DeleteFromLeft(inputArray));
    }

    @Test public void DeleteFromLeft2() {
        ArrayList<ArrayList<Integer>> inputArray = new ArrayList<>();

        ArrayList<ArrayList<Integer>> expectedArray = new ArrayList<>();

        assertEquals(expectedArray, CompressGrid.DeleteFromLeft(inputArray));
    }

    @Test public void DeleteFromLeft3() {
        ArrayList<ArrayList<Integer>> inputArray = new ArrayList<>();
        inputArray.add(new ArrayList<>(Arrays.asList(0,0,0,0)));
        inputArray.add(new ArrayList<>(Arrays.asList(0,0,0,0)));

        ArrayList<ArrayList<Integer>> expectedArray = new ArrayList<>();

        assertEquals(expectedArray, CompressGrid.DeleteFromLeft(inputArray));
    }

    @Test public void DeleteFromRight1() {
        ArrayList<ArrayList<Integer>> inputArray = new ArrayList<>();
        inputArray.add(new ArrayList<>(Arrays.asList(0,0,0,0)));
        inputArray.add(new ArrayList<>(Arrays.asList(0,0,0,0)));
        inputArray.add(new ArrayList<>(Arrays.asList(0,0,1,0)));
        inputArray.add(new ArrayList<>(Arrays.asList(0,0,1,0)));
        inputArray.add(new ArrayList<>(Arrays.asList(0,0,0,0)));

        ArrayList<ArrayList<Integer>> expectedArray = new ArrayList<>();
        expectedArray.add(new ArrayList<>(Arrays.asList(0,0,0)));
        expectedArray.add(new ArrayList<>(Arrays.asList(0,0,0)));
        expectedArray.add(new ArrayList<>(Arrays.asList(0,0,1)));
        expectedArray.add(new ArrayList<>(Arrays.asList(0,0,1)));
        expectedArray.add(new ArrayList<>(Arrays.asList(0,0,0)));

        assertEquals(expectedArray, CompressGrid.DeleteFromRight(inputArray));
    }

    @Test public void DeleteFromRight2() {
        ArrayList<ArrayList<Integer>> inputArray = new ArrayList<>();

        ArrayList<ArrayList<Integer>> expectedArray = new ArrayList<>();

        assertEquals(expectedArray, CompressGrid.DeleteFromRight(inputArray));
    }

    @Test public void DeleteFromRight3() {
        ArrayList<ArrayList<Integer>> inputArray = new ArrayList<>();
        inputArray.add(new ArrayList<>(Arrays.asList(0,0,0,0)));
        inputArray.add(new ArrayList<>(Arrays.asList(0,0,0,0)));

        ArrayList<ArrayList<Integer>> expectedArray = new ArrayList<>();

        assertEquals(expectedArray, CompressGrid.DeleteFromRight(inputArray));
    }
}
