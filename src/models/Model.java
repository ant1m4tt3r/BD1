package models;

import java.util.List;
import java.util.stream.Collectors;

import models.beans.Bean;
import services.Service;

public abstract class Model<T extends Bean> {
	
	public abstract List<T> selectAll();

	public abstract T select(int id);

	public abstract T delete(int id);

	public abstract T update(int i);

//	public abstract List<Plant> selectByName(String text);
	
	public List<T> selectByName(String name) {
		if (name.isEmpty())
			return selectAll();

		List<T> list = this.selectAll().stream()
				.filter(t -> t.getName().toLowerCase().contains(name))
				.collect(Collectors.toList());

		return list;
	}

}
