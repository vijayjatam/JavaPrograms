package com.kali.security;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class FirstProgram {
    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        Cipher cipher = Cipher.getInstance("AES");
        Key key = (Key) new ObjectInputStream(new BufferedInputStream(new FileInputStream("stri")));
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] plainText  = "abcdefghijklmnopqrstuvwxyz".getBytes("UTF-8");
        byte[] cipherText = cipher.doFinal(plainText);
        byte[] plainText1 = cipher.doFinal(cipherText);
        System.out.println(plainText1);
    }
}
