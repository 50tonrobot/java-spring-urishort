package com.urishort;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by mike on 4/17/17.
 */
public class UriKey {
    public static final String NUMERALS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-_.~";
    public static final int BASE = NUMERALS.length();

    public static String getUriKey(int uriId) {
        StringBuilder uriKey = new StringBuilder();
        int clonedUriId = uriId;
        while (clonedUriId > 0) {
            uriKey.insert(0, NUMERALS.charAt(clonedUriId % BASE));
            clonedUriId = clonedUriId / BASE;
        }
        return uriKey.toString();
    }

    public static int getUriId(String uriKey) {
        Integer uriId = 0;
        for (int i = 0; i < uriKey.length(); i++) {
            uriId = uriId * BASE + NUMERALS.indexOf(uriKey.charAt(i));
        }

        return uriId;
    }

    public static String getUriShort(int uriId) {
        byte[] ipAddress = new byte[] { 127, 0, 0, 1 };
        InetAddress address = null;
        try {
            address = InetAddress.getByAddress(ipAddress);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "http://" + address.getCanonicalHostName() + "/" + UriKey.getUriKey(uriId);
    }

}
