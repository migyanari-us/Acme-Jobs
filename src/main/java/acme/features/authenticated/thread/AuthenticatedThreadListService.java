
package acme.features.authenticated.thread;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.threads.Thread;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedThreadListService implements AbstractListService<Authenticated, Thread> {

	@Autowired
	AuthenticatedThreadRepository repository;

	@Override
	public boolean authorise(final Request<Thread> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Thread> request, final Thread entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "moment");		
	}

	@Override
	public Collection<Thread> findMany(final Request<Thread> request) {
		assert request != null;

		Collection<Thread> result;

		int userId = request.getPrincipal().getActiveRoleId();
		result = this.repository.findManyByUserId(userId);

		return result;
	}

}
