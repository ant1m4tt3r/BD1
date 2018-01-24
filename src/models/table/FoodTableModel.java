package models.table;

import java.util.List;

import models.Model;
import models.beans.Food;
//import models.beans.Plant;


public class FoodTableModel extends CustomTableModel<Food> {
	
	private static final long serialVersionUID = 1L;

	private final String[] columnNames = new String[] { "Codigo", "Nome",
			"Tipo" , "Action"};

	@SuppressWarnings({ "rawtypes" })
	private final Class[] columnClass = new Class[] { Integer.class, String.class,
			String.class , ButtonColumn.class};

	public FoodTableModel(Model<Food> model) {
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
	
	public void updateValues(List<Food> foods) {
		for (Food food : foods) {
			Object data[] = new Object[4];
			data[0] = food.getId();
			data[1] = food.getName();
			data[2] = food.getKind();
			data[3] = "DELETE";
			this.addRow(data);
		}
	}

	

}
