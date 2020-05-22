package com.mapcurtain.exleplat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mapcurtain.exleplat.entities.User;

class UserTests {
	
	private EntityManager em;
	private static EntityManagerFactory emf;
	private User user;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("exleplat");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		user = em.find(User.class, "orangeisntblue");
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		user = null;
	}

	@Test
	void test() {
		assertNotNull(user);
		assertEquals("password", user.getPassword());
	}
	
	@Test
	void testProfile() {
		assertEquals("jp.sypniewski@gmail.com", user.getProfile().getEmail());
	}

}
