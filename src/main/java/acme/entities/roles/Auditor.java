
package acme.entities.roles;

import javax.validation.constraints.NotBlank;

import acme.framework.entities.UserRole;

public class Auditor extends UserRole {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				firm;

	@NotBlank
	private Boolean				responsibilityStatement;
}
