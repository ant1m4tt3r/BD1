package services;

import java.util.List;

import db.Connection;

public abstract class Service<T> {

	private Connection connection = null;
	
	public Service() {
		this.connection = Connection.getInstance();
	}
	
	public abstract List<T> selectAll();
	
	public abstract T select();
	
	public abstract T delete();
	
	public abstract T update(String id);
	
}
