package mrpaper.business.domain;

public class University {
	
	private int id;
	private String name;
	
	public University(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return String.format("[ID: %s, NAME: %s]",
				this.id, this.name);
	}

}
