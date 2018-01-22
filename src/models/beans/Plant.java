package models.beans;

public class Plant extends Bean {

	private int id;
	private String name;
	private String depto;

	public Plant(int id, String name, String depto) {
		this.id = id;
		this.name = name;
		this.depto = depto;
	}

	public Plant() {
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

	public String getDepto() {
		return depto;
	}

	public void setDepto(String depto) {
		this.depto = depto;
	}

}
