package parking.refactored;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileReceiptLog implements ReceiptLog {
    private final Path file;

    public FileReceiptLog(String filename) { this.file = Path.of(filename); }

    public void write(String text) {
        try {
            Files.writeString(file, text + System.lineSeparator(),
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
