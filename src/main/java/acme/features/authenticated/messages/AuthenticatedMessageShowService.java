
package acme.features.authenticated.messages;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.messages.Messages;
import acme.entities.threads.Thread;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedMessageShowService implements AbstractShowService<Authenticated, Messages> {

	@Autowired
	AuthenticatedMessageRepository repository;


	@Override
	public boolean authorise(final Request<Messages> request) {
		assert request != null;
		Thread thread = this.repository.findThreadByMessageId(request.getModel().getInteger("id"));
		List<Authenticated> users = (List<Authenticated>) thread.getUsers();
		Principal principal = request.getPrincipal();
		boolean result = users.stream().filter(x -> x.getUserAccount().getId() == principal.getAccountId()).count() > 0;
		return result;
	}

	@Override
	public void unbind(final Request<Messages> request, final Messages entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "title", "moment", "tags", "body");
		model.setAttribute("author", entity.getUser().getUserAccount().getUsername());

	}

	@Override
	public Messages findOne(final Request<Messages> request) {

		assert request != null;

		Messages result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);
		return result;
	}

}
