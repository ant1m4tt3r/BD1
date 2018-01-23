package services;

import java.util.ArrayList;
import java.util.List;

public abstract class Service {

//	private Connection connection = null;
//	
//	public Service() {
//		this.connection = Connection.getInstance();
//	}
	
	public abstract List<ArrayList<Object>> selectAll();
	
	public abstract ArrayList<Object> select(int id);
	
	public abstract Object delete(int id);
	
	public abstract int update(int id, ArrayList<Object> row);
	
	public abstract void insert(ArrayList<Object> row);
	
}
