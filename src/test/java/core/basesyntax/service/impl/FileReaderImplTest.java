package core.basesyntax.service.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileReaderImplTest {
    private FileReaderImpl fileReaderImpl;

    @BeforeEach
    void beforeEach() {
        fileReaderImpl = new FileReaderImpl();
    }

    @Test
    void convertToTransaction_OK() {
        fileReaderImpl.readTransactionsFromFile("testFile.csv");
    }

    @Test
    void convertToTransaction_wrongFileName_ThrowsException() {
        assertThrows(RuntimeException.class, () ->
                fileReaderImpl.readTransactionsFromFile("test.csv"));
    }
}
