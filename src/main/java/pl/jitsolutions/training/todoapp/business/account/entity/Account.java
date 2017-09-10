package pl.jitsolutions.training.todoapp.business.account.entity;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;
import pl.jitsolutions.training.todoapp.business.common.boundary.BaseEntity;

@Entity
@Getter
@Setter
public class Account extends BaseEntity {

	private String userName;

	private String password;

	private boolean active;

}
