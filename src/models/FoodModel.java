package models;

import java.util.List;

import models.beans.Food;
import services.FoodService;

public class FoodModel extends Model<Food> {
	
	FoodService service;

	public FoodModel() {
		service = new FoodService();
	}
	
	@Override
	public List<Food> selectAll() {
		service.selectAll();
		return null;
	}

	@Override
	public Food select(int id) {
		service.select(id);
		return null;
	}

	@Override
	public boolean delete(int id) {
		return service.delete(id);
	}

	@Override
	public boolean update(Food row) {
		return service.update(row.getId(), null);
	}
	
	@Override
	public boolean insert(Food row) {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Food> selectByName(String text) {
		// TODO Auto-generated method stub
		return null;
	}

}
