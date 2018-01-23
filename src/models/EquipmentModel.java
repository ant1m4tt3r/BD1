package models;

import java.util.List;

import models.beans.Equipment;
import services.EquipmentService;

public class EquipmentModel extends Model<Equipment> {

	EquipmentService service;

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
	public Equipment update(Equipment row) {
		service.update(row.getId(), null);
		return null;
	}

	@Override
	public void insert(Equipment row) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Equipment> selectByName(String text) {
		// TODO Auto-generated method stub
		return null;
	}

}
