
package acme.features.authenticated.messages;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.messages.Messages;
import acme.entities.threads.Thread;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedMessageListService implements AbstractListService<Authenticated, Messages> {

	@Autowired
	AuthenticatedMessageRepository repository;


	@Override
	public boolean authorise(final Request<Messages> request) {
		assert request != null;
		Thread thread = this.repository.findThreadById(request.getModel().getInteger("id"));
		List<Authenticated> authenticateds = (List<Authenticated>) thread.getUsers();
		Principal principal = request.getPrincipal();
		boolean result = authenticateds.stream().filter(x -> x.getUserAccount().getId() == principal.getAccountId()).count() > 0;
		return result;
	}

	@Override
	public void unbind(final Request<Messages> request, final Messages entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "tags", "moment");
	}

	@Override
	public Collection<Messages> findMany(final Request<Messages> request) {

		assert request != null;

		Collection<Messages> result;
		Thread thread = this.repository.findThreadById(request.getModel().getInteger("id"));
		thread.getMessages().size();
		result = thread.getMessages();
		return result;
	}

}
