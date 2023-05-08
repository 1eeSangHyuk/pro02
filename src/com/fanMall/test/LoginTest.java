package com.fanMall.test;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.crypto.util.AES256;

public class LoginTest {

	public static void main(String[] args) {
		String a = "";
		// TODO Auto-generated method stub
		try {
			a = AES256.encryptAES256("1234", "%03x");
		} catch (InvalidKeyException | NoSuchAlgorithmException
				| InvalidKeySpecException | NoSuchPaddingException
				| InvalidParameterSpecException | UnsupportedEncodingException
				| BadPaddingException | IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(a);
		
		String b = "";
		try {
			b = AES256.decryptAES256(a, "%03x");
		} catch (InvalidKeyException | NoSuchPaddingException
				| NoSuchAlgorithmException | InvalidKeySpecException
				| InvalidAlgorithmParameterException | BadPaddingException
				| IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(b);
	}

}
