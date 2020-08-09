package personal.JavaAWS.svc;

import java.util.Iterator;
import java.util.List;

import personal.JavaAWS.entity.ColorsEntity;
import personal.JavaAWS.model.BasicForm;

public interface PortfolioSvc {

	public BasicForm repeater(BasicForm basicForm);
	
	public Iterator<ColorsEntity> allColors();
}
