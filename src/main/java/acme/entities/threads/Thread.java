package acme.entities.threads;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import acme.datatypes.UserIdentity;
import acme.entities.messages.Messages;
import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Thread extends DomainEntity {

	private static final long serialVersionUID = 43L;

	@NotBlank
	private String title;

	@NotBlank
	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date moment;

	@NotBlank
	private List<Thread> messages;

	@NotBlank
	private List<UserIdentity> users;

}
