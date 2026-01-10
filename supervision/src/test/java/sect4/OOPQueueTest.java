package sect4;

import org.junit.jupiter.api.Test;
import uk.ac.cam.mr2083.sect5.oopdatastructures.EmptyQueueException;
import uk.ac.cam.mr2083.sect5.oopdatastructures.OOPArrayQueue;
import uk.ac.cam.mr2083.sect5.oopdatastructures.OOPListQueue;
import uk.ac.cam.mr2083.sect5.oopdatastructures.OOPQueue;

import static org.junit.jupiter.api.Assertions.*;

public class OOPQueueTest {
    private void queueTest(OOPQueue queue) throws EmptyQueueException {
        assertTrue(queue.isEmpty());
        assertThrows(EmptyQueueException.class, queue::dequeue);
        assertThrows(EmptyQueueException.class, queue::peek);
        assertEquals(0, queue.length());

        queue.enqueue(1);
        assertEquals(1, queue.length());
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.peek());

        queue.enqueue(2);
        assertEquals(1, queue.peek());
        assertEquals(2, queue.length());

        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.peek());
        assertEquals(1, queue.length());

        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);

        assertEquals(5, queue.length());
        assertEquals(2, queue.peek());

        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertEquals(4, queue.dequeue());
        assertEquals(5, queue.dequeue());
        assertEquals(6, queue.dequeue());

        assertTrue(queue.isEmpty());
    }

    @Test
    public void listQueueTest() throws EmptyQueueException {
        queueTest(new OOPListQueue());
    }

    @Test
    public void arrayQueueTest() throws EmptyQueueException {
        queueTest(new OOPArrayQueue());
    }

}
