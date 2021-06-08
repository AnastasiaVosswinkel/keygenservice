package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class LicenseKey implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String product;
	private String keyComment;
	private String decryptedKey;
	private String encryptedKey;
	public LicenseKey(int id, String name, String product, String keyComment, String decryptedKey,
			String encryptedKey) {
		super();
		this.id = id;
		this.name = name;
		this.product = product;
		this.keyComment = keyComment;
		this.decryptedKey = decryptedKey;
		this.encryptedKey = encryptedKey;
	}
	public LicenseKey() {
		
	}
	
	public LicenseKey(String product) {
		super();
		this.product = product;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getKeyComment() {
		return keyComment;
	}
	public void setKeyComment(String keyComment) {
		this.keyComment = keyComment;
	}
	public String getDecryptedKey() {
		return decryptedKey;
	}
	public void setDecryptedKey(String decryptedKey) {
		this.decryptedKey = decryptedKey;
	}
	public String getEncryptedKey() {
		return encryptedKey;
	}
	public void setEncryptedKey(String encryptedKey) {
		this.encryptedKey = encryptedKey;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((decryptedKey == null) ? 0 : decryptedKey.hashCode());
		result = prime * result + ((encryptedKey == null) ? 0 : encryptedKey.hashCode());
		result = prime * result + id;
		result = prime * result + ((keyComment == null) ? 0 : keyComment.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LicenseKey other = (LicenseKey) obj;
		if (decryptedKey == null) {
			if (other.decryptedKey != null)
				return false;
		} else if (!decryptedKey.equals(other.decryptedKey))
			return false;
		if (encryptedKey == null) {
			if (other.encryptedKey != null)
				return false;
		} else if (!encryptedKey.equals(other.encryptedKey))
			return false;
		if (id != other.id)
			return false;
		if (keyComment == null) {
			if (other.keyComment != null)
				return false;
		} else if (!keyComment.equals(other.keyComment))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "LicenseKey [id=" + id + ", name=" + name + ", product=" + product + ", keyComment=" + keyComment
				+ ", decryptedKey=" + decryptedKey + ", encryptedKey=" + encryptedKey + "]";
	}

	
}
