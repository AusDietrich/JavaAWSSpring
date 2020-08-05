package personal.JavaAWS.svc;

import org.springframework.stereotype.Service;

import personal.JavaAWS.model.BasicForm;


@Service
public class PortfolioSvcImpl implements PortfolioSvc {

	@Override
	public BasicForm repeater(BasicForm basicForm) {
		System.out.println(basicForm.toString());
		return basicForm;
	}

}
