
package acme.features.administrator.investorRecords;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.investorRecords.InvestorRecord;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("/administrator/investor-record/")
public class AdministratorInvestorRecordController extends AbstractController<Administrator, InvestorRecord> {

	@Autowired
	private AdministratorInvestorRecordListService listService;

	@Autowired
	private AdministratorInvestorRecordShowService showService;

	@Autowired
	private AdministratorInvestorRecordsCreateService createService;

	@Autowired
	private AdministratorInvestorRecordDeleteService deleteService;

	@Autowired
	private AdministratorInvestorRecordsUpdateService updateService;

	@PostConstruct
	private void inicialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
	}

}
