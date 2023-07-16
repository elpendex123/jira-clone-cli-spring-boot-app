package com.example.jirausers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryTests {

	@Autowired
	UserRepository repository;

	User lalo, dougie, stanley;

	@BeforeEach
	public void setUp() {
		repository.deleteAll();
		lalo = repository.save(new User("C67555", "landersson2@privacy.gov.au", "Lalo Andersson", "Payment Adjustment Coordinator", "Engineering", "8/5/2011", false, "Tatooine", "400-428-9089"));
		dougie = repository.save(new User("P85957", "dsaunderson3@google.com.hk", "Dougie Saunderson", "Occupational Therapist", "Marketing", "1/14/2017", true, "Phoenix", "211-577-7435"));
		stanley = repository.save(new User("T38077", "sandrelli4@sitemeter.com", "Stanley Andrelli", "Chief Design Engineer", "HR", "10/31/2011", false, "Tatooine", "531-395-1033"));
	}

	@Test
	public void setsIdOnSave() {
		User lalo = repository.save(new User("C67555", "landersson2@privacy.gov.au", "Lalo Andersson", "Payment Adjustment Coordinator", "Engineering", "8/5/2011", false, "Tatooine", "400-428-9089"));
		assertThat(lalo.id).isNotNull();
	}

	@Test
	public void findByDepartment() {
		List<User> result = repository.findByDepartment("Engineering");
		assertThat(result).hasSize(1).extracting("team").contains("Tatooine");
	}

	// @Test
	// public void findsByExample() {
	// 	User probe = new User(null, "Matthews");
	// 	List<User> result = repository.findAll(Example.of(probe));
	// 	assertThat(result).hasSize(2).extracting("firstName").contains("Dave", "Oliver August");
	// }
}
