package models.table;

import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;

import models.Model;
import models.beans.Bean;

public abstract class CustomTableModel<T extends Bean> extends AbstractTableModel {

	protected List<T> list;
	protected Model<T> model;
	private final String[] columnNames = new String[] { "Id", "Nome",
			"Departamento" };
	@SuppressWarnings("rawtypes")
	private final Class[] columnClass = new Class[] { Integer.class, String.class,
			String.class };
	private static final long serialVersionUID = 1L;

	public CustomTableModel(List<T> list, Model<T> model) {
		this.model = model;
		this.list = model.selectAll();
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return columnClass[columnIndex];
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return list.size();
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex != 0;
	}

	@Override
	public abstract void setValueAt(Object value, int rowIndex, int columnIndex);

	@Override
	public abstract Object getValueAt(int rowIndex, int columnIndex);

	public abstract void tableChanged(T row);
	
}
