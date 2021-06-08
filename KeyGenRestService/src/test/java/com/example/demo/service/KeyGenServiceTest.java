package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dao.IKeyGenDao;
import com.example.demo.model.LicenseKey;

@SpringBootTest
public class KeyGenServiceTest {
	static Logger log = LoggerFactory.getLogger(KeyGenServiceTest.class);
	@Autowired
	private IKeyGenService service;

	@Autowired
	private IKeyGenDao dao;

	@BeforeEach
	void init() {
		// dao.deleteAll();
	}

	@Test
	public void testAttachattachLicenseKey() throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		
		
		service.attachLicenseKey(new LicenseKey());
		
	}
	
	@Test
	public void testGetAll() {
		List<LicenseKey> li = service.getAll();
		log.debug(">>>>>>>>LicenseKeys" + li);
		assertNotNull(li);
		
	}
}
