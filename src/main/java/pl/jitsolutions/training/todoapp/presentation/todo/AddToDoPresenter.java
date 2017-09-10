package pl.jitsolutions.training.todoapp.presentation.todo;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import lombok.Getter;
import pl.jitsolutions.training.todoapp.business.todo.boundary.ToDoCreator;
import pl.jitsolutions.training.todoapp.business.todo.entity.ToDo;

@Named
@Getter
@RequestScoped
public class AddToDoPresenter {

	private ToDo toDo = new ToDo();

	@EJB
	private ToDoCreator toDoCreator;

	public String save() {
		toDoCreator.save(toDo);

		return "todos";
	}
}
