package pl.jitsolutions.training.todoapp.business.account.boundary;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pl.jitsolutions.training.todoapp.business.account.entity.Account;

@Stateless
public class AccountProvider {

	@PersistenceContext
	private EntityManager entityManager;

	public Account getLoggedUser() {
		TypedQuery<Account> query = entityManager.createQuery("SELECT a FROM Account a WHERE a.userName = :userName", Account.class);
		query.setParameter("userName", "user1");
		return query.getSingleResult();
	}
}
