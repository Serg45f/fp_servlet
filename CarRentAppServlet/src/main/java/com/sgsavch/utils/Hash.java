package com.sgsavch.utils;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;

import java.security.*;

public class Hash {
    public static void main(String[] args) {
        try {
            System.out.println(hash("1","MD5"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

//        System.out.println(Integer.decode("$2a$12$hiE.0uTgHP4azd1HUbiJLOfFrpAX5lSNsQ1KbRZLSK5YJzx9kKjlO"));    // output 1234
////and vice versa
//        System.out.println(Integer.toHexString(1234)); //  output is 4d2);

    }

    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();

    public static String hash(String input, String algorithm) throws NoSuchAlgorithmException{
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        digest.update(input.getBytes());
        byte[] hash = digest.digest();

        char[] hexChars = new char[hash.length * 2];
        for ( int j = 0; j < hash.length; j++ ) {
            int v = hash[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }
}
