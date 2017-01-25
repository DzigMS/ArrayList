import org.junit.Before;
import org.junit.Test;
import ua.dp.DzMS.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ArrayListTest {
    ArrayList arrayList;

    @Before
    public void before() {
        arrayList = new ArrayList();
        for (int i = 0; i < 5; i++) {
            arrayList.add(i*1111);
        }
        arrayList.add(3333);
    }

    @Test
    public void testGet() {
        for (int i = 0; i < arrayList.size; i++){
            assertEquals(i*1111,arrayList.get(i));
        }
        assertEquals(null, arrayList.get(arrayList.size));
        assertEquals(null, arrayList.get(arrayList.size*50));
    }

    @Test
    public void testSizeAfterAdd(){
        int beforAdd = arrayList.size;
        arrayList.add(arrayList.size);
        int afterAdd = arrayList.size;
        assertEquals(beforAdd, afterAdd - 1);
    }

    @Test
    public void testAddWithParametr(){
        arrayList.add(1111, 0);
        assertEquals(1111, arrayList.get(0));
        arrayList.add(2222, 0);
        assertEquals(2222, arrayList.get(0));
        arrayList.add(3333, 1);
        assertEquals(3333, arrayList.get(1));
        arrayList.add(4444, 5);
        assertEquals(4444, arrayList.get(5));
        arrayList.add(arrayList.size, arrayList.size);
        assertEquals(arrayList.size - 1, arrayList.get(arrayList.size - 1));
        arrayList.add(77777, arrayList.size + 1);
        assertEquals(null, arrayList.get(arrayList.size));
    }

    @Test
    public void testRemoveIndex(){
        for (int i = 0; i < 5; i++) {
            assertEquals(i*1111, arrayList.remove(0));
            assertEquals(5-i, arrayList.size);
        }
        assertEquals(3333, arrayList.remove(0));
        assertEquals(0, arrayList.size);
        assertEquals(null, arrayList.remove(0));
        arrayList.add(1111);
        assertEquals(1111, arrayList.get(0));
        assertEquals(1, arrayList.size);
        before();
        for (int i = 0; i < 3; i++) {
            assertEquals(i*1111, arrayList.remove(0));
        }
        for (int i = 3; i < 5; i++) {
            assertEquals(null, arrayList.remove(3));
        }
        assertEquals(3, arrayList.size);
    }

    @Test
    public  void testRemoveObject(){
        arrayList.remove((Object) 3333);
        assertEquals(0, arrayList.get(0));
        assertEquals(1111, arrayList.get(1));
        assertEquals(2222, arrayList.get(2));
        assertEquals(4444, arrayList.get(3));
        assertEquals(3333, arrayList.get(4));
        assertEquals(null, arrayList.get(5));
        assertEquals(5, arrayList.size);

        arrayList.remove((Object) 2222);
        assertEquals(0, arrayList.get(0));
        assertEquals(1111, arrayList.get(1));
        assertEquals(4444, arrayList.get(2));
        assertEquals(3333, arrayList.get(3));
        assertEquals(null, arrayList.get(4));
        assertEquals(null, arrayList.get(5));
        assertEquals(4, arrayList.size);

        arrayList.remove((Object) 3333);
        assertEquals(0, arrayList.get(0));
        assertEquals(1111, arrayList.get(1));
        assertEquals(4444, arrayList.get(2));
        assertEquals(null, arrayList.get(3));
        assertEquals(null, arrayList.get(4));
        assertEquals(null, arrayList.get(5));
        assertEquals(3, arrayList.size);

        arrayList.remove((Object) 5555);
        assertEquals(0, arrayList.get(0));
        assertEquals(1111, arrayList.get(1));
        assertEquals(4444, arrayList.get(2));
        assertEquals(null, arrayList.get(3));
        assertEquals(null, arrayList.get(4));
        assertEquals(null, arrayList.get(5));
        assertEquals(3, arrayList.size);
    }

    @Test
    public void testSet(){
        assertEquals(0, arrayList.get(0));
        assertEquals(1111, arrayList.get(1));
        arrayList.set(3333, 0);
        assertEquals(3333, arrayList.get(0));
        assertEquals(1111, arrayList.get(1));
        arrayList.set(7777, 7);
        assertEquals(null, arrayList.get(7));
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

}
