package models.table;

import java.util.List;

import models.Model;
import models.beans.User;

public class UserTableModel extends CustomTableModel<User> {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private final String[] columnNames = new String[] { "Id", "Nome",
			"Departamento" };

	@SuppressWarnings({ "unused", "rawtypes" })
	private final Class[] columnClass = new Class[] { Integer.class, String.class,
			String.class };

	public UserTableModel(List<User> list, Model<User> model) {
		super(list, model);
	}

	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		System.out.println("SET");
		User row = this.list.get(rowIndex);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		User row = this.list.get(rowIndex);
		return null;
	}

	@Override
	public void tableChanged(User row) {
		// TODO Auto-generated method stub

	}

}
