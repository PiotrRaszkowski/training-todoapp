package pl.jitsolutions.training.todoapp.business.todo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;
import pl.jitsolutions.training.todoapp.business.common.boundary.BaseEntity;

@Getter
@Setter
@Builder
@Entity
@NamedQueries({
		@NamedQuery(name = ToDo.GET_TODOS_QUERY, query = "SELECT t FROM ToDo t")
})
public class ToDo extends BaseEntity {

	private final static String PREFIX = "pl.jitsolutions.training.todoapp.business.todo.entity.";

	public final static String GET_TODOS_QUERY = PREFIX + "getTodos";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(min = 4, max = 32)
	private String title;

	private String description;

	@Tolerate
	public ToDo() {
	}
}
