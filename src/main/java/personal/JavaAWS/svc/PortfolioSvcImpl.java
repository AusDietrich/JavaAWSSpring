package personal.JavaAWS.svc;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import personal.JavaAWS.entity.ColorsEntity;
import personal.JavaAWS.model.BasicForm;
import personal.JavaAWS.repo.ColorsRepo;


@Service
public class PortfolioSvcImpl implements PortfolioSvc {

	@Autowired
	ColorsRepo colorsRepo;
	
	@Override
	public BasicForm repeater(BasicForm basicForm) {
		return basicForm;
	}

	@Override
	public Iterator<ColorsEntity> allColors() {
		Iterable<ColorsEntity> allColors = colorsRepo.findAll();
		Iterator<ColorsEntity> iterColor = allColors.iterator();
		return iterColor;
	}
}
