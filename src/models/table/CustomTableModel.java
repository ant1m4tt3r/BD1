package models.table;

import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import models.Model;
import models.beans.Bean;
import models.beans.Plant;

public abstract class CustomTableModel<T extends Bean> extends DefaultTableModel {

	protected List<T> list;
	protected Model<T> model;
	private static final long serialVersionUID = 1L;

	public CustomTableModel(Model<T> model) {
		this.model = model;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex != 0;
	}
	
	@Override
	public abstract int getColumnCount();
	
	@Override
	public abstract String getColumnName(int column);

	@Override
	public abstract Class<?> getColumnClass(int columnIndex);
	
	public abstract void updateValues(List<T> beans);
	
}
