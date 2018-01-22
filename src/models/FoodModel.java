package models;

import java.util.List;

import models.beans.Food;
import models.beans.Plant;
import services.FoodService;

public class FoodModel extends Model<Food> {

	private FoodService service;

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
	public Food update(int id) {
		service.update(id);
		return null;
	}

	@Override
	public List<Food> selectByName(String text) {
		// TODO Auto-generated method stub
		return null;
	}

}
