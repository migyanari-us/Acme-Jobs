
package acme.entities.applications;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;

import acme.entities.jobs.Job;
import acme.entities.roles.Worker;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Application extends DomainEntity {

	private static final long	serialVersionUID	= 3L;

	@Column(unique = true)
	@NotBlank
	@Length(min = 9, max = 14)
	private String				reference;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date				moment;

	@NotBlank
	private String				status;

	@NotBlank
	private String				statement;

	@NotBlank
	private String				skills;

	@NotBlank
	private String				qualifications;

	// Relationship

	@NotNull
	@OneToOne(optional = false)
	private Job					job;

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Worker				worker;
}
