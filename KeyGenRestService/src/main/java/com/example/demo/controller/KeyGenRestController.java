package com.example.demo.controller;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.LicenseKey;

import com.example.demo.service.IKeyGenService;

@RequestMapping("/licensekeys")
@RestController
public class KeyGenRestController {
	@Autowired
	private IKeyGenService service;
	
	// http://localhost:8089/licensekeys
	@RequestMapping
	public List<LicenseKey> getAllPersons() {
		return service.getAll();
	}
	
	// http://localhost:8089/licensekeys/encryptedkey?licensekey=12BD348D447B90B0F57BDEB20A86C11D
	@GetMapping("/encryptedkey") //
	public LicenseKey getListByDecryptedKey(@RequestParam("licensekey") String encryptedKey ) {
		return service.getByEncryptedKey(encryptedKey);
	}
	
	@PostMapping("/generate")
	public LicenseKey newLicenseKey(@RequestBody LicenseKey lk) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		return service.attachLicenseKey(lk);
	}
	

}
