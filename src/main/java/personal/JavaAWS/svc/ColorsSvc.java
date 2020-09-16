package personal.JavaAWS.svc;

import java.util.Iterator;

import personal.JavaAWS.entity.ColorsEntity;

public interface ColorsSvc {

	public ColorsEntity addColor(ColorsEntity colorForm);
	
	public Iterator<ColorsEntity> allColors();
	
	public void removeColor(ColorsEntity colorsForm);
}
