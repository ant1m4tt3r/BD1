package models;

import java.util.List;
import java.util.stream.Collectors;

import models.beans.Bean;
import models.beans.User;
import services.Service;

public abstract class Model<T extends Bean> {
	
	public abstract List<T> selectAll();

	public abstract T select(int id);

	public abstract T delete(int id);

	public abstract T update(T row);

	public abstract void insert(T row);

	public abstract List<T> selectByName(String text);

}
