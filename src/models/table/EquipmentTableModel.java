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

	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		System.out.println("SET");
		Equipment row = this.list.get(rowIndex);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Equipment row = this.list.get(rowIndex);
		return null;
	}

	@Override
	public void tableChanged(Equipment row) {
		// TODO Auto-generated method stub
		
	}

}
