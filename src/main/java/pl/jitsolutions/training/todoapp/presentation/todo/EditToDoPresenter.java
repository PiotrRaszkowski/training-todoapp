package pl.jitsolutions.training.todoapp.presentation.todo;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import pl.jitsolutions.training.todoapp.business.todo.boundary.ToDoCreator;
import pl.jitsolutions.training.todoapp.business.todo.boundary.ToDoProvider;
import pl.jitsolutions.training.todoapp.business.todo.entity.ToDo;

@Named
@ViewScoped
@Slf4j
public class EditToDoPresenter implements Serializable {

	@Getter
	@Setter
	private Long todoId;

	@EJB
	private ToDoProvider toDoProvider;

	@EJB
	private ToDoCreator toDoCreator;

	@Getter
	@Setter
	private ToDo toDo;

	public void init() {
		log.info("Init EditToDoPresenter with id = {}.", todoId);

		toDo = toDoProvider.getTodo(todoId);
	}

	public void save() {
		toDoCreator.update(toDo);
	}
}
