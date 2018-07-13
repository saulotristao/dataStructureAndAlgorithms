package dataStructures.hashmap;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class HashmapTest {

    Hashmap<String, Number> testmap = new Hashmap();

    @Before
    public void setUp() throws Exception {
        testmap.add("Ryan", 36);
        testmap.add("Saulo", 56);
        testmap.add("Duncan", 8);
    }

    @Test
    public void remove() {
        testmap.remove("Saulo");
        assertFalse(testmap.find("Saulo"));
    }

    @Test
    public void add() {
        testmap.add("Madioka", 21);
        assertNotNull(testmap.find("Madioka"));
    }

    @Test
    public void find() {
        assertTrue(testmap.find("Duncan"));
    }
}