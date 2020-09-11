package personal.JavaAWS.svc;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import personal.JavaAWS.entity.ColorAngularEntity;
import personal.JavaAWS.entity.ColorsEntity;
import personal.JavaAWS.repo.AngularRepo;
import personal.JavaAWS.repo.ColorsRepo;


@Service
public class PortfolioSvcImpl implements PortfolioSvc {

	@Autowired
	ColorsRepo colorsRepo;
	
	@Override
	public ColorsEntity addColor(ColorsEntity colorForm) {
		colorsRepo.save(colorForm);
		return colorForm;
	}

	@Override
	public Iterator<ColorsEntity> allColors() {
		Iterable<ColorsEntity> allColors = colorsRepo.findAll();
		Iterator<ColorsEntity> iterColor = allColors.iterator();
		return iterColor;
	}
	
	@Override
	public void removeColor(ColorsEntity colorsForm) {
		colorsRepo.deleteById(colorsForm.getId());
	}
	
}
