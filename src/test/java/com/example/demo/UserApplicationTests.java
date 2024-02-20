package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@SpringBootTest
class UserApplicationTests {

	@Autowired
	UserRepository repo;
	
	@Test
	public void testCreate()
	{
		User user = new User();
		user.setUserId(11l);
		user.setUsername("suresh");
        user.setPassword("suresh@123");
        user.setEmail("suresh@gmail.com");
        user.setRole(Role.STUDENT);
        user.setFirstName("suresh");
        user.setLastName("reddy");
        user.setDateOfBirth(LocalDate.of(1990, 1, 1));
        user.setCreatedAt(LocalDateTime.now());
        repo.save(user);
        assertNotNull(repo.findById(11l).get());

	}
	@Test
 	public void testRead() {
 		List<User> list = repo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	@Test
	public void testSingleUser()
	{
		User use = repo.findById(2l).get();
		assertEquals("Catherin",use.getUsername());
	}
	
	@Test 
	public void testUpdate() {
		User u = repo.findById(2l).get();
		u.setFirstName("vada");
         repo.save(u);
	assertNotEquals("vadalpati",repo.findById(2l).get().getFirstName());
 	}
	
	@Test
	public void testDelete() {
 		repo.deleteById(5l);
 		assertThat(repo.existsById(5l)).isFalse();
 	}

}
