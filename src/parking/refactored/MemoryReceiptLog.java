package parking.refactored;

import java.util.ArrayList;
import java.util.List;

public class MemoryReceiptLog implements ReceiptLog {
    private final List<String> entries = new ArrayList<>();

    public void write(String text) { entries.add(text); }
    public List<String> entries() { return List.copyOf(entries); }
}
