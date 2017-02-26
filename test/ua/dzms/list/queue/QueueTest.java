package ua.dzms.list.queue;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class QueueTest {
    Queue<Object> queue;

    @Before
    public void before(){
        queue = new Queue();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i*1111);
        }
    }

    @Test
    public void testEnqueue(){
        for (int i = 0; i < 3; i++) {
            queue.enqueue((i+5)*1111);
        }
        for (int i = 0; i < 8; i++) {
            assertEquals(i*1111, queue.dequeue());
        }


    }

    @Test(expected = NullPointerException.class)
    public void testDequeue(){
        for (int i = 0; i < 5; i++) {
            assertEquals(i*1111, queue.dequeue());
        }
        queue.dequeue();
    }

    @Test
    public void testIsEmpty(){
        for (int i = 0; i < 5; i++) {
            assertFalse(queue.isEmpty());
            queue.dequeue();
        }
        assertTrue(queue.isEmpty());
    }
}
