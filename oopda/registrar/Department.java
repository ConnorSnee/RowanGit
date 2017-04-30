package registrar;


public enum Department {
	Art, Biology, Chemistry, Computer_Science, Economics, English, 
	History, Music, Mathematics, Philosophy, Physics, Psychology;
	
	public String toString() {
		return this.name().replace('_', ' ');
	}
}
