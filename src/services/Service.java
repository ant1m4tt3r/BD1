package services;

import java.util.ArrayList;
import java.util.List;

import db.Connection;

public abstract class Service {

//	private Connection connection = null;
//	
//	public Service() {
//		this.connection = Connection.getInstance();
//	}
	
	public abstract List<ArrayList<Object>> selectAll();
	
	public abstract Object select(int id);
	
	public abstract Object delete(int id);
	
	public abstract Object update(int id);
	
}
