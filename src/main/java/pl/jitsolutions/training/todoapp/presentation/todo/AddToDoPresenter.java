package pl.jitsolutions.training.todoapp.presentation.todo;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.Getter;
import pl.jitsolutions.training.todoapp.business.account.entity.Account;
import pl.jitsolutions.training.todoapp.business.todo.boundary.ToDoCreator;
import pl.jitsolutions.training.todoapp.business.todo.entity.ToDo;
import pl.jitsolutions.training.todoapp.presentation.account.LoggedAccount;

@Named
@Getter
@RequestScoped
public class AddToDoPresenter {

	private ToDo toDo = new ToDo();

	@EJB
	private ToDoCreator toDoCreator;

	@Inject
	@LoggedAccount
	private Account account;

	public String save() {
		toDo.setAccountId(account.getId());

		toDoCreator.save(toDo);

		return "todos";
	}
}
