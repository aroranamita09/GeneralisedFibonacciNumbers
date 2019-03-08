package  com.stackroute;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GeneralisedFibonacciTest {
    GeneralisedFibonacci obj;
    @Before
    public void setUp() throws Exception {
        obj = new GeneralisedFibonacci();
    }

    @After
    public void tearDown() throws Exception {
        obj = null;
    }


    @Test
    public void matPow() {
        assertEquals(98,obj.matPow(new long[][] {{200,4000,5,9},{2,4,5}},7,80000));
    }

    @Test
    public void prod() {
        assertEquals("",obj.prod(new long[]{3,5,6},new long[][]{{3,4,5,5},{2,4,5}},5));
    }

    @Test
    public void prod1() {
        assertEquals("",obj.prod(new long[]{3,5,6},new long[][]{{3,4,5,5},{2,4,5}},5));
    }
}