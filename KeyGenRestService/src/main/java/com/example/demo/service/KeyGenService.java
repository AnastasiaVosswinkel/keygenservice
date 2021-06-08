package com.example.demo.service;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Random;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.constant.Const;
import com.example.demo.dao.IKeyGenDao;
import com.example.demo.model.LicenseKey;
@Service
public class KeyGenService implements IKeyGenService {
	@Autowired 
	private IKeyGenDao dao;
	

	@Override
	public LicenseKey attachLicenseKey (LicenseKey lk) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		
		// Encrypt Key using AES algorithm, hexadecimal and product information
		Random rand = new Random();
		int a = 1;
		int c = 9999999;
		int M2nummer = a + rand.nextInt(c - a + 1);
		
		String decryptedKey = "product1" + M2nummer;

		Cipher cipher = Cipher.getInstance("AES");
		SecretKeySpec key = new SecretKeySpec(Const.M2KEY.getBytes(), "AES");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] bytes = cipher.doFinal(decryptedKey.getBytes());
		String encryptedKey = "";
		for (byte b : bytes) {
			System.out.println((char) b);
			encryptedKey = encryptedKey + String.format("%02X ", b);
			encryptedKey=encryptedKey.replaceAll("\\s+", "");

		}

		lk.setEncryptedKey(encryptedKey);
		lk.setDecryptedKey(decryptedKey);
		
		return dao.save(lk);
	}

	@Override
	public List<LicenseKey> getAll() {
		
		return dao.findAll();
	}

	@Override
	public LicenseKey getByEncryptedKey(String encryptedKey) {
		
		return dao.findByEncryptedKey(encryptedKey);
	}

}
