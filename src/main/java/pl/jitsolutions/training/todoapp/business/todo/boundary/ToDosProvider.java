package pl.jitsolutions.training.todoapp.business.todo.boundary;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pl.jitsolutions.training.todoapp.business.todo.entity.ToDo;

@Stateless
public class ToDosProvider {

	@PersistenceContext
	private EntityManager entityManager;

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<ToDo> getTodos() {
		TypedQuery<ToDo> query = entityManager.createNamedQuery(ToDo.GET_TODOS_QUERY, ToDo.class);
		return query.getResultList();
	}

}
