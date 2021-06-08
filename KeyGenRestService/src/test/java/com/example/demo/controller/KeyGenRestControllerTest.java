package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo.model.LicenseKey;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
public class KeyGenRestControllerTest {
	static Logger log = LoggerFactory.getLogger(KeyGenRestControllerTest.class);

	@Autowired
	private WebApplicationContext context; // Zugriff auf die SpringBoot App

	private MockMvc mockMvc;

	

	@BeforeEach
	void setUp() {
		DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(context);
		mockMvc = builder.build();
	}

	@Test
	public void testGetAll() {

		try {
			MvcResult result = mockMvc.perform(get("/licensekeys")).andExpect(status().isOk()).andReturn();
			String json = result.getResponse().getContentAsString();
			assertNotNull(json);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Test
	public void testattachLicenseKey() throws Exception {
		String url = "/licensekeys/generate";
		LicenseKey licenseKey = new LicenseKey();
		licenseKey.setProduct("product");
		
		ObjectMapper objectMapper = new ObjectMapper();
		String inputJson = objectMapper.writeValueAsString(licenseKey);
		
		
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
			.andExpect(status().isOk()).andReturn();
		
		//int status = mvcResult.getResponse().getStatus();
		//assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		String[] contentArr = content.replace('"',' ').replace("}", "").split(":");
		String encryptedKey = contentArr[contentArr.length-1];
		log.debug(">>>>>>>>Encrypted Key:" + encryptedKey);		
		log.debug(">>>>>>>>Key:" + content) 
;
	
		assertNotNull(content);

	}
	@Test
	public void getByEncryptedKey() {

		try {
			MvcResult result = mockMvc.perform(get("localhost:8089/licensekeys/encryptedkey?licensekey=12BD348D447B90B0F57BDEB20A86C11D")).andExpect(status().isOk()).andReturn();
			String json = result.getResponse().getContentAsString();
			assertNotNull(json);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
