package pl.jitsolutions.training.todoapp.business.common.boundary;

import java.time.LocalDateTime;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@MappedSuperclass
public class BaseEntity {
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
