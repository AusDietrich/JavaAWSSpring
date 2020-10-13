package personal.JavaAWS.svc;

import java.util.Iterator;

import personal.JavaAWS.entity.ColorsEntity;
import personal.JavaAWS.entity.ErrorMessage;

public interface ColorsSvc {

	public ColorsEntity addColor(ColorsEntity colorForm);
	
	public Iterator<ColorsEntity> allColors();
	
	public void removeColor(ColorsEntity colorsForm);

}
