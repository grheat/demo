package demo;

import java.util.LinkedHashMap;
import java.util.Map;

public class FIFOCache extends LinkedHashMap {
    private final int cacheSize;

    public FIFOCache(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > cacheSize;
    }
}
