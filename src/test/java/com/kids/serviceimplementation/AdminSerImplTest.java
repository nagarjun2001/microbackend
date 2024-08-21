package com.kids.serviceimplementation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.kids.KidsApplication;
import com.kids.model.Admin;

@SpringBootTest
@ContextConfiguration
class AdminSerImplTest {
	
	@Autowired
	AdminSerImpl service;

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAdminSerImpl() {
		fail("Not yet implemented");
	}

	@Test
	void testAddAdmin() {
		Admin admin = new Admin(2,"test","test","test");
		assertEquals("Admin added successfully!", service.addAdmin(admin));	
	}

	@Test
	void testGetAllAdmin() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAdminById() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAdminByUsername() {
		fail("Not yet implemented");
	}

}
