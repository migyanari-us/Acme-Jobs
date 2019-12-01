package acme.entities.messages;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import acme.framework.datatypes.Money;
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

	@NotBlank
	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date moment;

	private String tags;

	@NotBlank
	private String body;

}
