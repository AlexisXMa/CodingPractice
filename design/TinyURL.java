package design;

/*
535. Encode and Decode TinyURL
 */

import java.util.*;

public class TinyURL {
    // Method: Using hashcode
    Map<Integer, String> map = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        map.put(longUrl.hashCode(), longUrl);
        return "http://tinyurl.com/" +  longUrl.hashCode();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int key = Integer.valueOf(shortUrl.replace("http://tinyurl.com/", ""));
        return map.get(key);
    }
}
