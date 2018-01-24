package services;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import db.GetConnection;

public abstract class Service {

	protected Connection connection = null;
	
	public Service() {
		this.connection = GetConnection.getInstance();
	}
	
	public abstract List<ArrayList<Object>> selectAll();
	
	public abstract ArrayList<Object> select(int id);
	
	public abstract boolean delete(int id);
	
	public abstract boolean update(int id, ArrayList<Object> row);
	
	public abstract boolean insert(ArrayList<Object> row);
	
}
