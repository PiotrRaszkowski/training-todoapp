package pl.jitsolutions.training.todoapp.business.account.boundary;

import javax.annotation.PostConstruct;
import javax.ejb.DependsOn;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pl.jitsolutions.training.todoapp.business.account.entity.Account;

@Singleton
@Startup
@DependsOn(value = {"TestDataLoader"})
public class AccountActivator {

	@PersistenceContext
	private EntityManager entityManager;

	@PostConstruct
	public void init() {
		TypedQuery<Account> query = entityManager.createQuery("SELECT a FROM Account a WHERE a.userName = :userName", Account.class);
		query.setParameter("userName", "user1");
		Account account = query.getSingleResult();

		account.setActive(true);
		entityManager.merge(account);
	}
}
