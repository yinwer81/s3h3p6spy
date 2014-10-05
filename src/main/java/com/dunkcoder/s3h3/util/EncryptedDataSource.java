package com.dunkcoder.s3h3.util;

import java.io.IOException;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

// reassign JRE System Library into BuildPath will fix all warnings on this class
public class EncryptedDataSource extends DriverManagerDataSource {

    @Override
    public String getUsername() {
        String username = super.getUsername();
        return decode(username);
    }

    @Override
    public String getPassword() {
        String password = super.getPassword();
        return decode(password);
    }

    @SuppressWarnings("restriction")
	private String decode(String decode) {
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            decode = new String(decoder.decodeBuffer(decode));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return decode;
    }

    public static void main(String[] args) {
        String password = "pa55w0rd"; // pa55w0rd
        BASE64Encoder encoder = new BASE64Encoder();
        String encryptedPassword = encoder.encode(password.getBytes());
        System.out.println(encryptedPassword);
    }
}
