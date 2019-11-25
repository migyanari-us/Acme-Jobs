
package acme.entities.roles;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import acme.framework.entities.UserRole;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Auditor extends UserRole {

	private static final long	serialVersionUID	= 18L;

	@NotBlank
	private String				firm;

	@NotBlank
	private String				responsibilityStatement;
}
