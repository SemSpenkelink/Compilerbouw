package pp.block3.cp.serverclient;

import java.util.HashMap;

/*
 * No synchronization whatsoever
 * However, how are the students going to fix this? Having a map with a single lock isn't very good voor performance...
 */

public class LocalCache {

    LocalCache(ClientSettings settings_) {
        settings = settings_;
        cacheMap = new HashMap<String,CacheEntry>();
    }
    
    private ClientSettings settings;
    private HashMap<String,CacheEntry> cacheMap;
    
    private class CacheEntry {
        private long entryTime;
        private String response;
        
        CacheEntry(long entryTime_, String response_) {
            entryTime = entryTime_;
            response = response_;
        }
    }
    
    public void put(String request, String response) {
        cacheMap.put(request, new CacheEntry(System.currentTimeMillis(), response));
    }
    
    public String get(String request) {
        CacheEntry ce = cacheMap.get(request);
        
        //Entry not found
        if(ce == null) {
            return null;
        }
        
        //Check if it has expired yet and if so remove the item
        if(System.currentTimeMillis() - ce.entryTime > settings.getSettings().getCacheExpirationTime() * 1000) {
            cacheMap.remove(request);
            return null;
        }
        
        return ce.response;
    }
    
}
