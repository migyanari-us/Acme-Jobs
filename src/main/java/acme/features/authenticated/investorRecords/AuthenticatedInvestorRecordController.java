
package acme.features.authenticated.investorRecords;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.investorRecords.InvestorRecord;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("/authenticated/investor-record/")
public class AuthenticatedInvestorRecordController extends AbstractController<Authenticated, InvestorRecord> {

	@Autowired
	private AuthenticatedInvestorRecordListService listService;

	@Autowired
	private AuthenticatedInvestorRecordShowService showService;

	@PostConstruct
	private void inicialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
