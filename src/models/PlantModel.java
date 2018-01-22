package models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import models.beans.Plant;
import services.PlantService;

public class PlantModel extends Model<Plant> {

	private PlantService service;

	public PlantModel() {
		service = new PlantService();
	}

	@Override
	public List<Plant> selectAll() {
		List<ArrayList<Object>> list = service.selectAll();
		List<Plant> plants = new ArrayList<Plant>();
		for (ArrayList<Object> arrayList : list) {
			Plant plant = new Plant();
			plant.setId((int) arrayList.get(0));
			plant.setName((String) arrayList.get(1));
			plant.setDepto((String) arrayList.get(2));
			plants.add(plant);
		}
		return plants;
	}

	@Override
	public Plant select(int id) {
		service.select(id);
		return null;
	}

	@Override
	public Plant delete(int id) {
		service.delete(id);
		return null;
	}

	@Override
	public Plant update(int id) {
		service.update(id);
		return null;
	}

	public List<Plant> selectByName(String name) {
		if (name.isEmpty())
			return this.selectAll();

		List<Plant> list = this.selectAll().stream()
				.filter(plant -> plant.getName().toLowerCase().contains(name))
				.collect(Collectors.toList());

		return list;
	}

}
