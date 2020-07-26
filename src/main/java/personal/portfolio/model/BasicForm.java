package personal.portfolio.model;


public class BasicForm {

	private String name;
	private String words;
	
	@Override
	public String toString() {
		return "name: "+this.name+", words: "+this.words;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWords() {
		return words;
	}
	public void setWords(String words) {
		this.words = words;
	}
}
