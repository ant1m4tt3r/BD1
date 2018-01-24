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

import models.FoodModel;
import models.PlantModel;
import models.beans.Plant;
import models.table.ButtonColumn;
import models.table.FoodTableModel;
import models.table.PlantTableModel;

import models.beans.Food;
public class FoodPane extends CustomPane<Food> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FoodPane() {
		super("alimento");
		List<Food> foods = this.model.selectAll();
		initializing = true;
		tableModel.updateValues(foods);
		initializing = false;
	}

	protected void showInsertNewPlantModal() {
		JTextField name = new JTextField();
		JTextField kind = new JTextField();
		Object[] message = { "Nome:", name, "Tipo", kind };

		int option = JOptionPane.showConfirmDialog(null, message, "Inserir Alimento", JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION) {
			if (name.getText() == null || name.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Digite um nome válido");
				return;
			}
			if (kind.getText() == null || kind.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Digite um Tipo válido");
				return;
			}

			int id_ = 0;

			Food row = new Food(id_, name.getText(), kind.getText());
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
		this.model = new FoodModel();
		this.tableModel = new FoodTableModel(model);
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
					String kind = (String) tableModel.getValueAt(row, 2);
					Food f = new Food(id, name, kind);
					model.update(f);
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