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
	public Food delete(int id) {
		service.delete(id);
		return null;
	}

	@Override
	public Food update(Food row) {
		service.update(row.getId(), null);
		return null;
	}
	
	@Override
	public void insert(Food row) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Food> selectByName(String text) {
		// TODO Auto-generated method stub
		return null;
	}

}
