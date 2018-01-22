package models.table;

import java.util.List;

import models.Model;
import models.beans.Food;

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
	
	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		System.out.println("SET");
		Food row = this.list.get(rowIndex);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Food row = this.list.get(rowIndex);
		return null;
	}

	@Override
	public void tableChanged(Food row) {
		// TODO Auto-generated method stub
		
	}

}
