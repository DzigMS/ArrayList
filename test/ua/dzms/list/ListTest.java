package ua.dzms.list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

abstract public class ListTest {
    public List<Object> list;

    abstract List init();

    @Before
    public void before() {
        list = init();
        for (int i = 0; i < 5; i++) {
            list.add(i * 1111);
        }
    }

    @Test
    public void testIsEmpty() {
        assertFalse(list.isEmpty());
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testAddIndex() {
        assertEquals(5, list.size());

        list.add(6666, 0);
        assertEquals(6666, list.get(0));
        assertEquals(0, list.get(1));
        assertEquals(6, list.size());

        list.add(7777, 4);
        assertEquals(7777, list.get(4));
        assertEquals(6666, list.get(0));
        assertEquals(0, list.get(1));

        list.add(8888, 2);
        assertEquals(8888, list.get(2));
        assertEquals(4444, list.get(7));

        list.add(9999, 8);
        assertEquals(9999, list.get(8));
        assertEquals(9, list.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddIndexException() {
        list.add(1010, 10);
    }

    @Test
    public void testGet() {
        for (int i = 0; i < 5; i++) {
            assertEquals(i * 1111, list.get(i));
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetException() {
        list.get(5);
    }

    @Test
    public void testContains() {
        for (int i = 0; i < 5; i++) {
            assertTrue(list.contains(i * 1111));
        }
        assertFalse(list.contains(5555));
        assertFalse(list.contains(null));
    }

    @Test
    public void testIndexOf() {
        assertEquals(3, list.indexOf(3333));
        assertEquals(-1, list.indexOf(7777));
        assertEquals(-1, list.indexOf(null));
    }

    @Test
    public void testLastIndexOf() {
        list.add(3333);
        assertEquals(5, list.lastIndexOf(3333));
        assertEquals(-1, list.lastIndexOf(7777));
        assertEquals(-1, list.lastIndexOf(null));
    }

    @Test
    public void testSet() {
        assertEquals(0, list.get(0));
        assertEquals(1111, list.get(1));
        assertEquals(2222, list.get(2));
        list.set(3333, 0);
        assertEquals(3333, list.get(0));
        assertEquals(1111, list.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetException() {
        list.set(7777, 7);
    }

    @Test
    public void testRemoveObject() {
        list.remove((Object) 0);
        for (int i = 0; i < 4; i++) {
            assertEquals((i + 1) * 1111, list.get(i));
        }

        list.remove((Object) 3333);
        assertEquals(1111, list.get(0));
        assertEquals(2222, list.get(1));
        assertEquals(4444, list.get(2));

        list.remove((Object) 4444);
        assertEquals(1111, list.get(0));
        assertEquals(2222, list.get(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveObjectException() {
        list.remove((Object) 7777);
    }


    @Test
    public void testRemoveIndex() {
        list.remove(0);
        for (int i = 0; i < 4; i++) {
            assertEquals((i + 1) * 1111, list.get(i));
        }

        list.remove(2);
        assertEquals(1111, list.get(0));
        assertEquals(2222, list.get(1));
        assertEquals(4444, list.get(2));

        list.remove(2);
        assertEquals(1111, list.get(0));
        assertEquals(2222, list.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveIndexException() {
        list.remove(7);
    }
}
