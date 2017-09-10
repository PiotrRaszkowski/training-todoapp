package pl.jitsolutions.training.todoapp.presentation.todo;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import lombok.Getter;
import pl.jitsolutions.training.todoapp.business.todo.boundary.ToDosProvider;
import pl.jitsolutions.training.todoapp.business.todo.entity.ToDo;

@Named
@RequestScoped
public class ToDosPresenter implements Serializable {

	@EJB
	private ToDosProvider toDosProvider;

	@Getter
	private List<ToDo> toDos;

	@PostConstruct
	public void init() {
		toDos = toDosProvider.getTodos();
	}
}
