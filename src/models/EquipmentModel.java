package models;

import java.util.List;

import models.beans.Equipment;
import models.beans.Plant;
import services.EquipmentService;

public class EquipmentModel extends Model<Equipment> {

	private EquipmentService service;

	public EquipmentModel() {
		service = new EquipmentService();
	}

	@Override
	public List<Equipment> selectAll() {
		service.selectAll();
		return null;
	}

	@Override
	public Equipment select(int id) {
		service.select(id);
		return null;
	}

	@Override
	public Equipment delete(int id) {
		service.delete(id);
		return null;
	}

	@Override
	public Equipment update(int id) {
		service.update(id);
		return null;
	}

	@Override
	public List<Equipment> selectByName(String text) {
		// TODO Auto-generated method stub
		return null;
	}

}
