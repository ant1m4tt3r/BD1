package models.beans;

import java.util.Date;

public class Equipment extends Bean {

	private int id;
	private String name;
	private String manufacturer;
	private String localization;
	private Date lastMaintance;
	private float current;

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

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getLocalization() {
		return localization;
	}

	public void setLocalization(String localization) {
		this.localization = localization;
	}

	public Date getLastMaintance() {
		return lastMaintance;
	}

	public void setLastMaintance(Date lastMaintance) {
		this.lastMaintance = lastMaintance;
	}

	public float getCurrent() {
		return current;
	}

	public void setCurrent(float current) {
		this.current = current;
	}

}
