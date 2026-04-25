package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileWriterImpl implements FileWriter {
    private static final String OUTPUT_DIR = "target/";

    @Override
    public void write(String report, String fileName) {

        try (PrintWriter writer = new PrintWriter(OUTPUT_DIR + fileName)) {
            writer.println(report);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't create or write to file", e);
        }

    }
}
