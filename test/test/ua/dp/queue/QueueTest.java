package test.ua.dp.queue;


import org.junit.Before;
import org.junit.Test;
import ua.dp.queue.Queue;
import static org.junit.Assert.*;


public class QueueTest {
    Queue queue;

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
            assertEquals((i+4)*1111, queue.getLastNode().getValue());
            assertEquals(0, queue.getFirstNode().getValue());
            queue.enqueue((i+5)*1111);
            assertEquals((i+5)*1111, queue.getLastNode().getValue());
            assertEquals(0, queue.getFirstNode().getValue());
        }
    }

    @Test(expected = NullPointerException.class)
    public void testDequeue(){
        for (int i = 0; i < 5; i++) {
            assertEquals(i*1111, queue.getFirstNode().getValue());
            assertEquals(4444, queue.getLastNode().getValue());
            queue.dequeue();
            assertEquals((i+1)*1111, queue.getFirstNode().getValue());
            assertEquals(4444, queue.getLastNode().getValue());
        }
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
