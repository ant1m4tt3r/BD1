package models;

import java.util.ArrayList;

import models.beans.Plant;
import services.PlantService;

public class PlantModel extends Model<Plant> {

	PlantService service;

	public PlantModel() {
		service = new PlantService();
	}

	@Override
	public ArrayList<Plant> selectAll() {
		ArrayList<ArrayList<Object>> list = service.selectAll();
		ArrayList<Plant> plants = new ArrayList<Plant>();
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
	public boolean delete(int id) {
		return service.delete(id);
	}

	@Override
	public boolean update(Plant row) {
		ArrayList<Object> list = new ArrayList<Object>();
		list.add((int) row.getId());
		list.add((String) row.getName());
		list.add((String) row.getDepto());
		return service.update(row.getId(), list);
	}

	@Override
	public boolean insert(Plant row) {
		ArrayList<Object> list = new ArrayList<Object>();
		list.add((int) row.getId());
		list.add((String) row.getName());
		list.add((String) row.getDepto());
		return service.insert(list);
	}
	
	public ArrayList<Plant> selectByName(String text) {
		if (text == null || text.isEmpty())
			return selectAll();
		
		ArrayList<ArrayList<Object>> list = service.selectByName(text.toLowerCase());
		if (list == null || list.isEmpty())
			return new ArrayList<Plant>();
		
		ArrayList<Plant> plantList = new ArrayList<Plant>();
		Plant p;
		
		for (ArrayList<Object> row : list) {
			p = new Plant();
			p.setId((int) row.get(0));
			p.setName((String) row.get(1));
			p.setDepto((String) row.get(2));
			plantList.add(p);
		}
		
		return plantList;
	}

}
