package pl.jitsolutions.training.todoapp.business.todo.boundary;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pl.jitsolutions.training.todoapp.business.todo.entity.ToDo;

@Stateless
public class ToDoCreator {

	@PersistenceContext
	private EntityManager entityManager;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(ToDo toDo) {
		entityManager.persist(toDo);
	}
}
