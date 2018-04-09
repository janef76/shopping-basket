import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestItem {

    Item item;

    @Before
    public void before() {
        item = new Item("Golf ball", 4.99);
    }

    @Test
    public void getItemName() {
        assertEquals("Golf ball", item.getName());
    }

    @Test
    public void getItemPrice() {
        assertEquals(4.99, item.getPrice(), 0.01);
    }
}
