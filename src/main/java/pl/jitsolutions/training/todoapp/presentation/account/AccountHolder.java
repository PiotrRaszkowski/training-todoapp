package pl.jitsolutions.training.todoapp.presentation.account;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import lombok.Getter;
import pl.jitsolutions.training.todoapp.business.account.boundary.AccountProvider;
import pl.jitsolutions.training.todoapp.business.account.entity.Account;

@SessionScoped
@Named
public class AccountHolder implements Serializable {

	@Getter
	private Account loggedAccount;

	@EJB
	private AccountProvider accountProvider;

	@PostConstruct
	public void init() {
		loggedAccount = accountProvider.getLoggedUser();
	}

}
