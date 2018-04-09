import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestBasket {

    Basket basket;
    Item item1;
    Item item2;
    Item item3;

    @Before
    public void before() {
        basket = new Basket();
        item1 = new Item("tees", 1.99);
        item2 = new Item("ball", 4.95);
        item3 = new Item("driver", 100);
    }

    @Test
    public void canAddItemToBasket() {
        basket.addItem(item1);
        basket.addItem(item2);
        assertEquals(2, basket.countItems());
    }

    @Test
    public void canRemoveItemFromBasket() {
        basket.addItem(item1);
        basket.addItem(item2);
        basket.removeItem(item1);
        assertEquals(1, basket.countItems());
    }

    @Test
    public void canEmptyBasket() {
        basket.addItem(item1);
        basket.addItem(item2);
        basket.addItem(item3);
        basket.emptyAll();
        assertEquals(0, basket.countItems());
    }

    @Test
    public void canGetBasketSubTotal() {
        basket.addItem(item1);
        basket.addItem(item2);
        assertEquals(6.94, basket.getSubTotal(), 0.01);
    }

    @Test
    public void canGetBasketBOGOF() {
        basket.addItem(item1);
        basket.addItem(item1);
        basket.addItem(item2);
        basket.addItem(item2);
        assertEquals(6.94, basket.getSubTotal(), 0);
    }

    @Test
    public void canGetBOGOFOddNumber() {
        basket.addItem(item1);
        basket.addItem(item1);
        basket.addItem(item1);
        assertEquals(3.98, basket.getSubTotal(), 0);
    }

    @Test
    public void canGet10PercentOffOver20() {
        basket.addItem(item3);
        basket.addItem(item3);
        assertEquals(90, basket.getDiscountedTotal(), 0);
    }

    @Test
    public void noDiscountLessThan20() {
        basket.addItem(item2);
        basket.addItem(item2);
        assertEquals(4.95, basket.getDiscountedTotal(), 0);
    }

    @Test
    public void canUseDiscountCard() {
        basket.addItem(item3);
        basket.addItem(item3);
        basket.addItem(item1);
        basket.hasDiscountCard();
        assertEquals(89.96, basket.hasDiscountCard(), 0.01);
    }

    @Test
    public void noDiscountCard() {
        basket.addItem(item3);
        basket.addItem(item3);
        basket.addItem(item1);
        basket.hasNoDiscountCard();
        assertEquals(91.79, basket.hasNoDiscountCard(), 0.01);
    }

}
