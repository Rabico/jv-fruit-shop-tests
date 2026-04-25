package core.basesyntax.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FruitTransactionTest {

    @Test
    void FruitTransaction_negativeQuantity_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
                new FruitTransaction("b", "apple", -20));
    }
    @Test
    void FruitTransaction_nullFruit_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
                new FruitTransaction("b", null, 10));
    }
    @Test
    void FruitTransaction_blankFruit_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
                new FruitTransaction("b", "", 10));
    }
    @Test
    void FruitTransaction_OK() {
        FruitTransaction fruitTransaction_1 = new FruitTransaction("b", "apple", 20);
        FruitTransaction fruitTransaction_2 = new FruitTransaction("p", "banana", 25);
        FruitTransaction fruitTransaction_3 = new FruitTransaction("r", "cherry", 30);
        FruitTransaction fruitTransaction_4 = new FruitTransaction("s", "strawberry", 35);
        assertEquals(fruitTransaction_1.getName(), "apple");
        assertEquals(fruitTransaction_2.getName(), "banana");
        assertEquals(fruitTransaction_3.getName(), "cherry");
        assertEquals(fruitTransaction_4.getName(), "strawberry");
        assertEquals(fruitTransaction_1.getQuantity(), 20);
        assertEquals(fruitTransaction_2.getQuantity(), 25);
        assertEquals(fruitTransaction_3.getQuantity(), 30);
        assertEquals(fruitTransaction_4.getQuantity(), 35);
        assertEquals(fruitTransaction_1.getOperation(), Operation.BALANCE);
        assertEquals(fruitTransaction_2.getOperation(), Operation.PURCHASE);
        assertEquals(fruitTransaction_3.getOperation(), Operation.RETURN);
        assertEquals(fruitTransaction_4.getOperation(), Operation.SUPPLY);
    }
    @Test
    void FruitTransaction_nullOperation_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
                new FruitTransaction(null, "apple", 20));
    }
    @Test
    void FruitTransaction_wrongOperationCode_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
                new FruitTransaction("a", "apple", 20));
    }
}