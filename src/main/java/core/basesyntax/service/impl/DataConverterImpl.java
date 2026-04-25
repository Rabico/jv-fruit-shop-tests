package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> transactions) {
        return transactions.stream().map(s -> s.split(","))
                .map(this::parseTransaction)
                .toList();
    }

    private int parseInteger(String s) {

        int i = 0;
        try {
            i = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid integer: " + s);
        }
        return i;
    }

    private FruitTransaction parseTransaction(String[] s) {
        if (s.length != 3) {
            throw new IllegalArgumentException("wrong transaction length");
        }
        for (int i = 0; i < s.length; i++) {
            s[i] = s[i].trim();
        }
        return new FruitTransaction(s[0], s[1],
                parseInteger(s[2]));

    }
}
