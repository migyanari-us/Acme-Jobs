
package acme.features.authenticated.thread;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;
import acme.entities.threads.Thread;

@Repository
public interface AuthenticatedThreadRepository extends AbstractRepository {

	//Comprobando el formato de la tabla intermedia generada
	@Query("select t from Thread t where t.id in(select a.thread.id from Participations a where a.user.id= ?1)")
	Collection<Thread> findManyByUserId(int id);

	@Query("select t from Thread t where t.id = ?1")
	Thread findOneById(int id);
}
