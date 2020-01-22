/** @author bsv180000, sxa190016
 *  Doubly linked list: Short project 1
 *
 */

package bsv180000;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class SinglyLinkedListTest {

    /**
     * Unit test for hasNext method
     */
    @Test
    private void hasNextTest()
    {
        // when sll is null hasNext return false
        SinglyLinkedList<Integer> sll1 = null;
        Assert.assertFalse(sll1.iterator().hasNext());

        // when sll is just initialized hasNext gives false;
        SinglyLinkedList<Integer> sll2 = new SinglyLinkedList<>();
        Assert.assertFalse(sll2.iterator().hasNext());

        //when iterator has already iterated till end return false;
        sll2.add(new SinglyLinkedList.Entry<>(10, null));
        Assert.assertFalse(sll2.iterator().hasNext());

        // when iterator has not reached end
        SinglyLinkedList<Integer> sll3 = new SinglyLinkedList<>();
        sll3.add(new SinglyLinkedList.Entry<>(100, null));
        Assert.assertTrue(sll3.iterator().hasNext());
    }


    /**
     *  Unit test for next method
     */
    @Test
    private void nextTest()
    {
        // when sll is null next is null
        SinglyLinkedList<Integer> sll1 = null;
        Assert.assertNull(sll1.iterator().next());

        // when sll is just initialized next is null;
        SinglyLinkedList<Integer> sll2 = new SinglyLinkedList<>();
        Assert.assertNull(sll2.iterator().next());

        //when iterator has already iterated till end next will be null;
        sll2.add(new SinglyLinkedList.Entry<>(10, null));
        Assert.assertNull(sll2.iterator().next());

        // when iterator has not reached end
        SinglyLinkedList<Integer> sll3 = new SinglyLinkedList<>();
        sll3.add(new SinglyLinkedList.Entry<>(100, null));
        Assert.assertNotNull(sll3.iterator().next());
    }
}