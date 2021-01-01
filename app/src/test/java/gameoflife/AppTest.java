package gameoflife;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
    @Test public void testAdd() {
        String str = "Junit is working fine";
        assertEquals("Junit is working fine",str);
    }

    @Test public void nextGenerationTest() {
        System.out.println("blah");
//      ArrayList<ArrayList<Integer>> inputArray = new ArrayList<ArrayList<Integer>>();
//      inputArray.add(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0)));
//      inputArray.add(new ArrayList<Integer>(Arrays.asList(0,0,1,0,0)));
//      inputArray.add(new ArrayList<Integer>(Arrays.asList(0,0,1,0,0)));
//      inputArray.add(new ArrayList<Integer>(Arrays.asList(0,0,1,0,0)));
//      inputArray.add(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0)));
//
//      ArrayList<ArrayList<Integer>> expectedArray = new ArrayList<ArrayList<Integer>>();
//      inputArray.add(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0)));
//      inputArray.add(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0)));
//      inputArray.add(new ArrayList<Integer>(Arrays.asList(1,1,1,1,0)));
//      inputArray.add(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0)));
//      inputArray.add(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0)));
//
//      assertEquals(expectedArray, Home.nextGeneration(inputArray,5,5));
        assertEquals(5, App.blah());
    }
}
