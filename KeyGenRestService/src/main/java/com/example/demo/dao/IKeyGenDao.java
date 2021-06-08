package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.LicenseKey;

public interface IKeyGenDao extends CrudRepository<LicenseKey, Integer> {
	
	LicenseKey findByEncryptedKey(String encryptedKey);
	List<LicenseKey> findAll();
	
}
