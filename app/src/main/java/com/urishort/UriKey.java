package com.urishort;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by mike on 4/17/17.
 */
public class UriKey {
    public static final String NUMERALS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-_.~";
    public static final int BASE = NUMERALS.length();

    public static String getUriKey(long uriId) {
        StringBuilder uriKey = new StringBuilder();
        long clonedUriId = uriId;
        while (clonedUriId > 0) {
            uriKey.insert(0, NUMERALS.charAt((int) clonedUriId % BASE));
            clonedUriId = clonedUriId / BASE;
        }
        return uriKey.toString();
    }

    public static long getUriId(String uriKey) {
        long uriId = 0;
        for (int i = 0; i < uriKey.length(); i++) {
            uriId = uriId * BASE + NUMERALS.indexOf(uriKey.charAt(i));
        }

        return uriId;
    }

    public static String getUriShort(long uriId) {
        return UriKey.getUriKey(uriId);
    }

    public static UriShort setUriShort(UriShort uriShort) {
        uriShort.setUriShort(UriKey.getUriKey(uriShort.getUriId()));
        return uriShort;
    }

}
