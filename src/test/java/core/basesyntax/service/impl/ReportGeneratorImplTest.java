package core.basesyntax.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import core.basesyntax.db.StorageDao;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class ReportGeneratorImplTest {
    private StorageDao storageDao;
    private ReportGeneratorImpl reportGenerator;

    @Test
    void reportGenerator_Ok() {
        storageDao = mock(StorageDao.class);
        reportGenerator = new ReportGeneratorImpl(storageDao);
        Map<String, Integer> actualMap = new LinkedHashMap<>();
        actualMap.put("apple", 10);
        actualMap.put("orange", 20);
        when(storageDao.getData()).thenReturn(actualMap);
        StringBuilder expected = new StringBuilder();
        expected.append("fruit,quantity")
                .append(System.lineSeparator())
                .append("apple,10")
                .append(System.lineSeparator())
                .append("orange,20")
                .append(System.lineSeparator());
        String expectedString = expected.toString();
        String actualString = reportGenerator.generateReport();
        assertEquals(expectedString, actualString);
    }
}
