package registrar;


import java.util.ArrayList;

public class Term {
	
	private ArrayList<Section> sections;
	private String term;
	
	public Term(String name) {
		term = name;
		sections = new ArrayList<Section>();
	}
	
	public void addSection(Section newSection) {
		sections.add(newSection);
	}
	
	public String getName() {
		return term;
	}
	
	public ArrayList<Section> getSections() {
		return sections;
	}

}
