package pl.jitsolutions.training.todoapp.business.common.boundary;

import java.time.LocalDateTime;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDateTime created;

	private LocalDateTime modified;

	@PrePersist
	public void prePersist() {
		created = LocalDateTime.now();
	}

	@PreUpdate
	public void preUpdate() {
		modified = LocalDateTime.now();
	}
}
