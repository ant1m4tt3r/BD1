package views;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import models.PlantModel;
import models.beans.Plant;
import models.table.ButtonColumn;
import models.table.PlantTableModel;

public class PlantPane extends CustomPane<Plant> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PlantPane() {
		super("planta");
		List<Plant> plants = this.model.selectAll();
		initializing = true;
		tableModel.updateValues(plants);
		initializing = false;
	}

	protected void showInsertNewPlantModal() {
		JTextField name = new JTextField();
		JTextField depto = new JTextField();
		Object[] message = { "Nome:", name, "Departamento", depto };

		int option = JOptionPane.showConfirmDialog(null, message, "Inserir Planta", JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION) {
			if (name.getText() == null || name.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Digite um nome válido");
				return;
			}
			if (depto.getText() == null || depto.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Digite um departamento válido");
				return;
			}

			int id_ = 0;

			Plant row = new Plant(id_, name.getText(), depto.getText());
			boolean inserted = model.insert(row);
			search("");

			if (inserted)
				return;

			JOptionPane.showMessageDialog(null, "Houve um problema ao inserir.");

		} else {
			System.out.println("Login canceled");
		}

	}

	void createModels() {
		this.model = new PlantModel();
		this.tableModel = new PlantTableModel(model);
		this.table = new JTable();
		this.table.setModel(this.tableModel);
		this.tableModel.fireTableDataChanged();
		this.tableModel.addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				if (initializing)
					return;
				int row = e.getFirstRow();
				int count = tableModel.getRowCount();
				if (row < count) {
					int id = (int) tableModel.getValueAt(row, 0);
					String name = (String) tableModel.getValueAt(row, 1);
					String depto = (String) tableModel.getValueAt(row, 2);
					Plant p = new Plant(id, name, depto);
					model.update(p);
				}
			}
		});
		;

		Action delete = new AbstractAction() {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				JTable table = (JTable) e.getSource();
				int modelRow = Integer.valueOf(e.getActionCommand());
				model.delete((int) tableModel.getValueAt(modelRow, 0));
				((DefaultTableModel) table.getModel()).removeRow(modelRow);
				tableModel.fireTableDataChanged();
			}
		};

		ButtonColumn buttonColumn = new ButtonColumn(table, delete, 3);
		buttonColumn.setMnemonic(KeyEvent.VK_D);
	}

}
