package core.basesyntax.service.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileWriterImplTest {
    private FileWriterImpl fileWriterImpl;

    @BeforeEach
    void beforeEach() {
        fileWriterImpl = new FileWriterImpl();
    }

    @Test
    void writeReportToFile_OK() {
        fileWriterImpl.writeReportToFile("Report", "testOk");
    }

    @Test
    void writeReportToFile_emptyFile_ThrowsException() {
        assertThrows(RuntimeException.class, () ->
                fileWriterImpl.writeReportToFile("Report", ""));
    }

    @Test
    void writeReportToFile_nullFileName_ThrowsException() {
        assertThrows(RuntimeException.class, () ->
                fileWriterImpl.writeReportToFile("Report", null));
    }

}
