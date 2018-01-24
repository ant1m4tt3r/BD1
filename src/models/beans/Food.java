package models.beans;

public class Food extends Bean {
	
	private int id;
	private String name;
	private String kind;
	
	public Food(int id, String name, String kind) {
		this.id = id;
		this.name = name;
		this.kind = kind;
	}
	
	public Food() {
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

}
