package models.table;

import java.util.List;

import javax.swing.event.TableModelEvent;

import models.Model;
import models.beans.Equipment;
import models.beans.Food;

public class EquipmentTableModel extends CustomTableModel<Equipment> {
	
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unused")
	private final String[] columnNames = new String[] { "Id", "Nome",
			"Departamento" };

	@SuppressWarnings({ "unused", "rawtypes" })
	private final Class[] columnClass = new Class[] { Integer.class, String.class,
			String.class };
	
	public EquipmentTableModel(List<Equipment> list, Model<Equipment> model) {
		super(list, model);
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return columnClass[columnIndex];
	}

	public void updateValues(List<Equipment> equipments) {
		for (Equipment equipment : equipments) {
			Object data[] = new Object[3];
			this.addRow(data);
		}
	}

}
