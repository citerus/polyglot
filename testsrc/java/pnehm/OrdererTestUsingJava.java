package pnehm;

import junit.framework.TestCase;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class OrdererTestUsingJava extends TestCase {

    private void doTestOrderByFreq(Orderer orderer) {
        List<String> unordered = Arrays.asList("b", "d", "b", "b", "a", "c", "a");
        List<String> ordered = orderer.orderByFreq(unordered);
        assertEquals(Arrays.asList("b","a","c","d"), ordered);

        unordered = Arrays.asList("b", "d", "d", "e", "b", "a", "c", "a");
        ordered = orderer.orderByFreq(unordered);
        assertEquals(Arrays.asList("a","b","d","c", "e"), ordered);

        unordered = new ArrayList<String>();
        ordered = orderer.orderByFreq(unordered);
        assertTrue(unordered.isEmpty());
        assertEquals(new ArrayList<String>(), ordered);
    }

    public void testJavaImpl() {
        doTestOrderByFreq(new JavaOrderer());
    }

    public void testClojureImpl() {
        doTestOrderByFreq(new ClojureOrderer());
    }

    //public void testGroovyImpl() {
      //  doTestOrderByFreq(new GroovyOrderer());
    //}
    
}

