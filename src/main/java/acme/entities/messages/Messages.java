package acme.entities.messages;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import acme.entities.threads.Thread;
import acme.framework.entities.Authenticated;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Messages extends DomainEntity {

	private static final long serialVersionUID = 33L;

	@NotBlank
	private String title;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date moment;

	private String tags;

	@NotBlank
	private String body;
	
	@NotNull
	@ManyToOne(optional = false)
	private Thread thread;
	
	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Authenticated user;

}
