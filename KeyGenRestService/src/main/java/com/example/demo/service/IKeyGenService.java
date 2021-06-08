package com.example.demo.service;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.example.demo.model.LicenseKey;


public interface IKeyGenService {
	LicenseKey attachLicenseKey (LicenseKey lk) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException;
	List<LicenseKey> getAll();
	LicenseKey getByEncryptedKey(String encryptedKey);

}
