package acme.entities.threads;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import acme.entities.messages.Messages;
import acme.entities.participations.Participations;
import acme.framework.entities.Authenticated;
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

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date moment;

	@NotNull
	//Para mapear en base a los valores "thread" de mensajes
	@OneToMany(mappedBy = "thread")
	private Collection<Messages> messages;

	@NotNull
	//Asociación ManyToMany, pero creamos tabla intermedia y por tanto la referenciamos a ella
	//1 thread - muchas participaciones
	@OneToMany(mappedBy = "thread")
	private Collection<Participations> participations;
	
	@Transient
	public Collection<Authenticated> getUsers(){
		List<Participations> result = new ArrayList<>();
		result.addAll(participations);
		
		return result.stream().map(x->x.getUser()).collect(Collectors.toCollection(TreeSet::new));
	}
	
	

}
