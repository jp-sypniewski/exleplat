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

import com.mapcurtain.exleplat.entities.Profile;

class ProfileTests {
	
	private EntityManager em;
	private static EntityManagerFactory emf;
	private Profile profile;

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
		profile = em.find(Profile.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		profile = null;
	}

	@Test
	void test() {
		assertNotNull(profile);
		assertEquals("jp", profile.getFirstName());
	}

}
