package pl.jitsolutions.training.todoapp.test;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.extern.slf4j.Slf4j;
import pl.jitsolutions.training.todoapp.business.account.entity.Account;

@Singleton
@Startup
@Slf4j
public class TestDataLoader {

	@PersistenceContext
	private EntityManager entityManager;

	@PostConstruct
	public void init() {
		Account account1 = new Account();
		account1.setUserName("user1");
		account1.setPassword("password");
		entityManager.persist(account1);

		Account account2 = new Account();
		account2.setUserName("user2");
		account2.setPassword("password");
		entityManager.persist(account2);

		log.info("Test data initialized!");
	}
}
