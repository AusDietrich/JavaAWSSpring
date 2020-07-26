package personal.portfolio.svc;

import org.springframework.stereotype.Service;

import personal.portfolio.model.BasicForm;

@Service
public class PortfolioSvcImpl implements PortfolioSvc {

	@Override
	public BasicForm repeater(BasicForm basicForm) {
		System.out.println(basicForm.toString());
		return basicForm;
	}

	
}
