package models.table;

import java.util.List;
import models.table.CustomTableModel;

import models.Model;
import models.beans.Equipment;

public class EquipmentTableModel extends CustomTableModel<Equipment> {
	
	private static final long serialVersionUID = 1L;
	
	private final String[] columnNames = new String[] { "Id", "Nome",
			"Fabricante" , "Action"};

	@SuppressWarnings({ "rawtypes" })
	private final Class[] columnClass = new Class[] { Integer.class, String.class,
			String.class, ButtonColumn.class };
	
	public EquipmentTableModel(Model<Equipment> model) {
		super(model);
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
			Object data[] = new Object[4];
			data[0] = equipment.getId();
			data[1] = equipment.getName();
			data[2] = equipment.getManufacturer();
			data[3] = "DELETE";
			this.addRow(data);
		}
	}

	

}
