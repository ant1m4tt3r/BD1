package models;

import java.util.ArrayList;
//import java.util.List;

import models.beans.Equipment;
//import models.beans.Plant;
import services.EquipmentService;

public class EquipmentModel extends Model<Equipment> {

	EquipmentService service;

	public EquipmentModel() {
		service = new EquipmentService();
	}

	@Override
	public ArrayList<Equipment> selectAll() {
		ArrayList<ArrayList<Object>> list = service.selectAll();
		ArrayList<Equipment> equipments = new ArrayList<Equipment>();
		for (ArrayList<Object> arrayList : list) {
			Equipment equipment = new Equipment();
			equipment.setId((int) arrayList.get(0));
			equipment.setName((String) arrayList.get(1));
			equipment.setManufacturer((String) arrayList.get(2));
			equipments.add(equipment);
		}
		return equipments;
	}

	@Override
	public Equipment select(int id) {
		service.select(id);
		return null;
	}

	@Override
	public boolean delete(int id) {
		return service.delete(id);
	}

	@Override
	public boolean update(Equipment row) {
		ArrayList<Object> list = new ArrayList<Object>();
		list.add((int) row.getId());
		list.add((String) row.getName());
		list.add((String) row.getManufacturer());
		return service.update(row.getId(), list);
	}

	@Override
	public boolean insert(Equipment row) {
		ArrayList<Object> list = new ArrayList<Object>();
		list.add((int) row.getId());
		list.add((String) row.getName());
		list.add((String) row.getManufacturer());
		return service.insert(list);
	}
	

	@Override
	public ArrayList<Equipment> selectByName(String name) {
		if (name == null || name.isEmpty())
			return selectAll();

		ArrayList<ArrayList<Object>> list = service.selectByName(name.toLowerCase());
		if (list == null || list.isEmpty())
			return new ArrayList<Equipment>();

		ArrayList<Equipment> equipmentList = new ArrayList<Equipment>();
		Equipment e;

		for (ArrayList<Object> row : list) {
			e = new Equipment();
			e.setId((int) row.get(0));
			e.setName((String) row.get(1));
			e.setManufacturer((String) row.get(2));
			equipmentList.add(e);
		}

		return equipmentList;
	}

}
