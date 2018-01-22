package models.table;

import java.util.List;

import models.Model;
import models.beans.Plant;
import services.PlantService;

public class PlantTableModel extends CustomTableModel<Plant> {
	
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private final String[] columnNames = new String[] { "Id", "Nome",
			"Departamento" };

	@SuppressWarnings({ "unused", "rawtypes" })
	private final Class[] columnClass = new Class[] { Integer.class, String.class,
			String.class };

	public PlantTableModel(List<Plant> list, Model<Plant> model) {
		super(list, model);
	}
	
	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		Plant row = this.list.get(rowIndex);
		if (0 == columnIndex) {
			row.setId((int) value);
		} else if (1 == columnIndex) {
			row.setName(value.toString());
			tableChanged(row);
		} else if (2 == columnIndex) {
			row.setDepto(value.toString());
			tableChanged(row);
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Plant row = this.list.get(rowIndex);
		if (0 == columnIndex) {
			return row.getId();
		} else if (1 == columnIndex) {
			return row.getName();
		} else if (2 == columnIndex) {
			return row.getDepto();
		}
		return null;
	}

	@Override
	public void tableChanged(Plant row) {
		model.update(row.getId());
	}

}
