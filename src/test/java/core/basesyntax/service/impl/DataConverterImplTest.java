package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataConverterImplTest {
    DataConverterImpl dataConverterImpl = new DataConverterImpl();
    List<String> list = new ArrayList<>();;
    @BeforeEach
    void  setUp() {

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
        expected.add(new FruitTransaction("b", "banana", 10));
        expected.add(new FruitTransaction("p", "apple", 15));
        expected.add(new FruitTransaction("r", "cherry", 20));
        expected.add(new FruitTransaction("s", "strawberry", 25));
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
}