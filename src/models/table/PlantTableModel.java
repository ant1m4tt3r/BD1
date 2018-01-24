package models.table;

import java.util.List;

import models.Model;
import models.beans.Plant;

public class PlantTableModel extends CustomTableModel<Plant> {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private final String[] columnNames = new String[] { "Id", "Nome",
			"Departamento", "Action" };

	@SuppressWarnings({ "unused", "rawtypes" })
	private final Class[] columnClass = new Class[] { Integer.class, String.class,
			String.class , ButtonColumn.class};

	public PlantTableModel(Model<Plant> model) {
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
	
	
	public void updateValues(List<Plant> plants) {
		for (Plant plant : plants) {
			Object data[] = new Object[4];
			data[0] = plant.getId();
			data[1] = plant.getName();
			data[2] = plant.getDepto();
			data[3] = "DELETE";
			this.addRow(data);
		}
	}

}
