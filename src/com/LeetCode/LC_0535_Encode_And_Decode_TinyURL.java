package com.LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class LC_0535_Encode_And_Decode_TinyURL {

    Map<String, String> keyToVal = new HashMap<>();
    //Map<String, String> valToKey = new HashMap<>();
    static final String BASE_URL = "http://tinyurl.com/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        char[] charSet = new char[]{'1','2','3','4','5','6','7','8','9','0','q',
                'w','e','r','t','y','u','i','o','p','a','s',
                'd','f','g'};

        String key;
        do {
            StringBuilder str = new StringBuilder();
            for (int i = 0 ; i < 6 ; i++) {
                int idx = new Random().nextInt(charSet.length);
                str.append(charSet[idx]);
            }
            key = BASE_URL+str.toString();
        } while(keyToVal.containsKey(key));
        keyToVal.put(key, longUrl);
        //valToKey.put(longUrl, key);
        return key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return keyToVal.get(shortUrl);
    }
}
