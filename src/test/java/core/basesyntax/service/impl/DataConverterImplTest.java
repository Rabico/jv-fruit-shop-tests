package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DataConverterImplTest {
    private DataConverterImpl dataConverterImpl = new DataConverterImpl();
    private List<String> list = new ArrayList<>();

    @BeforeEach
    void beforeEach() {
        list.clear();
    }

    @Test
    void convertToTransaction_wrongInteger_ThrowsException() {

        list.add("b, apple, banana");
        assertThrows(IllegalArgumentException.class, () ->
                dataConverterImpl.convertToTransaction(list));
    }

    @Test
    void convertToTransaction_wrongTransaction_ThrowsException() {

        list.add("b, apple, 80, 20");
        assertThrows(IllegalArgumentException.class, () ->
                dataConverterImpl.convertToTransaction(list));
    }

    @Test
    void convertToTransaction_OK() {
        List<FruitTransaction> expected = new ArrayList<>();
        expected.add(new FruitTransaction(Operation.BALANCE, "banana", 10));
        expected.add(new FruitTransaction(Operation.PURCHASE, "apple", 15));
        expected.add(new FruitTransaction(Operation.RETURN, "cherry", 20));
        expected.add(new FruitTransaction(Operation.SUPPLY, "strawberry", 25));
        list.add("b, banana, 10");
        list.add("p, apple, 15");
        list.add("r, cherry, 20");
        list.add("s, strawberry, 25");
        List<FruitTransaction> actual = dataConverterImpl.convertToTransaction(list);
        assertEquals(expected.toArray()[0], actual.toArray()[0]);
        assertEquals(expected.toArray()[1], actual.toArray()[1]);
        assertEquals(expected.toArray()[2], actual.toArray()[2]);
        assertEquals(expected.toArray()[3], actual.toArray()[3]);
    }

    @Test
    void convertTransaction_wrongCode_ThrowsException() {
        list.add("a, apple, 80");
        assertThrows(IllegalArgumentException.class, () ->
                dataConverterImpl.convertToTransaction(list));
    }

    @Test
    void convertTransaction_emptyCode_ThrowsException() {
        list.add(", apple, 80");
        assertThrows(IllegalArgumentException.class, () ->
                dataConverterImpl.convertToTransaction(list));
    }

    @Test
    void convertTransaction_emptyFruit_ThrowsException() {
        list.add("b, , 80");
        assertThrows(IllegalArgumentException.class, () ->
                dataConverterImpl.convertToTransaction(list));
    }
}
