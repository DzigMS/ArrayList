package ua.dzms.list.arraylist;

import org.junit.Before;
import org.junit.Test;
import ua.dzms.list.ListTest;


import static org.junit.Assert.*;

public class ArrayListTest extends ListTest {
//    ArrayList arrayList;

    @Override
    public void before() {
        list = new ArrayList<>();
        super.before();
    }

/*
    @Before
    public void before() {
        arrayList = new ArrayList();
        for (int i = 0; i < 5; i++) {
            arrayList.add(i*1111);
        }
        arrayList.add(3333);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGet() {
        for (int i = 0; i < 5; i++){
            assertEquals(i*1111, arrayList.get(i));
        }
        assertEquals(3333, arrayList.get(5));
        arrayList.get(6);
    }

    @Test
    public void testSizeAfterAdd(){
        int beforAdd = arrayList.size();
        arrayList.add(arrayList.size());
        int afterAdd = arrayList.size();
        assertEquals(beforAdd, afterAdd - 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddWithParametr(){
        arrayList.add(1111, 0);
        assertEquals(1111, arrayList.get(0));
        assertEquals(0, arrayList.get(1));
        assertEquals(1111, arrayList.get(2));
        assertEquals(2222, arrayList.get(3));
        assertEquals(3333, arrayList.get(4));
        assertEquals(4444, arrayList.get(5));
        assertEquals(3333, arrayList.get(6));

        arrayList.add(2222, 0);
        assertEquals(2222, arrayList.get(0));
        assertEquals(1111, arrayList.get(1));
        assertEquals(0, arrayList.get(2));
        assertEquals(1111, arrayList.get(3));
        assertEquals(2222, arrayList.get(4));
        assertEquals(3333, arrayList.get(5));
        assertEquals(4444, arrayList.get(6));
        assertEquals(3333, arrayList.get(7));

        arrayList.add(3333, 1);
        assertEquals(2222, arrayList.get(0));
        assertEquals(3333, arrayList.get(1));
        assertEquals(1111, arrayList.get(2));
        assertEquals(0, arrayList.get(3));
        assertEquals(1111, arrayList.get(4));
        assertEquals(2222, arrayList.get(5));
        assertEquals(3333, arrayList.get(6));
        assertEquals(4444, arrayList.get(7));
        assertEquals(3333, arrayList.get(8));

        arrayList.add(4444, 5);
        assertEquals(4444, arrayList.get(5));
        arrayList.add(arrayList.size(), arrayList.size());
        assertEquals(arrayList.size() - 1, arrayList.get(arrayList.size() - 1));
        arrayList.add(7777, arrayList.size() + 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveIndex(){
        for (int i = 0; i < 5; i++) {
            assertEquals(i*1111, arrayList.remove(0));
            assertEquals(5-i, arrayList.size());
        }
        assertEquals(3333, arrayList.remove(0));
        assertEquals(0, arrayList.size());
        assertEquals(null, arrayList.remove(0));
        arrayList.add(1111);
        assertEquals(1111, arrayList.get(0));
        assertEquals(1, arrayList.size());

        before();
        assertEquals(1111, arrayList.remove(1));
        assertEquals(0, arrayList.get(0));
        assertEquals(2222, arrayList.get(1));
        assertEquals(3333, arrayList.get(2));
        assertEquals(4444, arrayList.get(3));
        assertEquals(3333, arrayList.get(4));
        assertEquals(null, arrayList.get(5));

    }

    @Test(expected = IllegalArgumentException.class)
    public  void testRemoveObject(){
        arrayList.remove((Object) 3333);
        assertEquals(0, arrayList.get(0));
        assertEquals(1111, arrayList.get(1));
        assertEquals(2222, arrayList.get(2));
        assertEquals(4444, arrayList.get(3));
        assertEquals(3333, arrayList.get(4));
        assertEquals(5, arrayList.size());

        arrayList.remove((Object) 2222);
        assertEquals(0, arrayList.get(0));
        assertEquals(1111, arrayList.get(1));
        assertEquals(4444, arrayList.get(2));
        assertEquals(3333, arrayList.get(3));
        assertEquals(4, arrayList.size());

        arrayList.remove((Object) 3333);
        assertEquals(0, arrayList.get(0));
        assertEquals(1111, arrayList.get(1));
        assertEquals(4444, arrayList.get(2));
        assertEquals(3, arrayList.size());

        arrayList.remove((Object) 5555);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSet(){
        assertEquals(0, arrayList.get(0));
        assertEquals(1111, arrayList.get(1));
        arrayList.set(3333, 0);
        assertEquals(3333, arrayList.get(0));
        assertEquals(1111, arrayList.get(1));
        arrayList.set(7777, 7);
    }

    @Test
    public void testIndexOf(){
        assertEquals(3, arrayList.indexOf(3333));
        assertEquals(-1, arrayList.indexOf(7777));
        assertEquals(-1, arrayList.indexOf(null));
    }

    @Test
    public void testLastIndexOf(){
        assertEquals(5, arrayList.lastIndexOf(3333));
        assertEquals(-1, arrayList.lastIndexOf(7777));
        assertEquals(-1, arrayList.lastIndexOf(null));
    }

    @Test
    public void testIsEmpty(){
        assertFalse(arrayList.isEmpty());
        arrayList.clear();
        assertTrue(arrayList.isEmpty());
    }

    @Test
    public void testContains(){
        for (int i = 0; i < 5; i++) {
            assertTrue(arrayList.contains(i*1111));
        }
        assertFalse(arrayList.contains(5555));
        assertFalse(arrayList.contains(null));
    }
*/
}
