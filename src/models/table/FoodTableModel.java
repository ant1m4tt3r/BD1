package models.table;

import java.util.List;

import models.Model;
import models.beans.Food;
import models.beans.User;

public class FoodTableModel extends CustomTableModel<Food> {
	
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private final String[] columnNames = new String[] { "Id", "Nome",
			"Departamento" };

	@SuppressWarnings({ "unused", "rawtypes" })
	private final Class[] columnClass = new Class[] { Integer.class, String.class,
			String.class };

	public FoodTableModel(List<Food> list, Model<Food> model) {
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
	
	public void updateValues(List<Food> foods) {
		for (Food food : foods) {
			Object data[] = new Object[3];
			this.addRow(data);
		}
	}

}
