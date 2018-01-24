package models;

import java.util.ArrayList;

import models.beans.Food;

import services.FoodService;

public class FoodModel extends Model<Food> {
	
	FoodService service;

	public FoodModel() {
		service = new FoodService();
	}
	
	@Override
	public ArrayList<Food> selectAll() {
		ArrayList<ArrayList<Object>> list = service.selectAll();
		ArrayList<Food> foods = new ArrayList<Food>();
		for (ArrayList<Object> arrayList : list) {
			Food food = new Food();				
			food.setId((int) arrayList.get(0));
			food.setName((String) arrayList.get(1));
			food.setKind((String) arrayList.get(2));
			foods.add(food);
		}
		service.selectAll();
		return foods;
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
		ArrayList<Object> list = new ArrayList<Object>();
		list.add((int) row.getId());
		list.add((String) row.getName());
		list.add((String) row.getKind());
		return service.update(row.getId(), list);
	}

	
	@Override
	public boolean insert(Food row) {
		ArrayList<Object> list = new ArrayList<Object>();
		list.add((int) row.getId());
		list.add((String) row.getName());
		list.add((String) row.getKind());
		return service.insert(list);
	}

	@Override
	public ArrayList<Food> selectByName(String text) {
		if (text == null || text.isEmpty())
			return selectAll();
		
		ArrayList<ArrayList<Object>> list = service.selectByName(text.toLowerCase());
		if (list == null || list.isEmpty())
			return new ArrayList<Food>();
		
		ArrayList<Food> foodList = new ArrayList<Food>();
		Food f;
		
		for (ArrayList<Object> row : list) {
			f = new Food();
			f.setId((int) row.get(0));
			f.setName((String) row.get(1));
			f.setKind((String) row.get(2));
			foodList.add(f);
		}
		
		return foodList;
	}

}
