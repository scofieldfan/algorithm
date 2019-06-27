package com.fan.dream.algorithm.design;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TinyURL {


    Random random = new Random();

    Map<String, String> map = new HashMap<>();

    public static void main(String[] args) {
        TinyURL tu = new TinyURL();
        System.out.println(tu.genRandomStr(5));
    }

    private String genRandomStr(int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            boolean isChar = random.nextInt(2) % 2 == 0 ? true : false;
            if (isChar) { // 产生字母
                int nextInt = random.nextInt(2) % 2 == 0 ? 65 : 97;
                // System.out.println(nextInt + "!!!!"); 1,0,1,1,1,0,0
                sb.append((char) (nextInt + random.nextInt(26)));
            } else { // 产生数字
                sb.append(String.valueOf(random.nextInt(10)));
            }
        }
        return sb.toString();
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {

        String shortURL = genRandomStr(5);
        map.put(shortURL, longUrl);
        return "http://" + shortURL;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl.substring(7));
    }
}
