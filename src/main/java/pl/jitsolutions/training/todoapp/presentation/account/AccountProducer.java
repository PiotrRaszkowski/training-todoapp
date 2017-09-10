package pl.jitsolutions.training.todoapp.presentation.account;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.extern.slf4j.Slf4j;
import pl.jitsolutions.training.todoapp.business.account.entity.Account;

@Slf4j
public class AccountProducer {

	@Inject
	private AccountHolder accountHolder;

	@Produces
	@LoggedAccount
	@Named
	public Account getLoggedAccount() {
		log.info("Producing logged account!");

		return accountHolder.getLoggedAccount();
	}
}
