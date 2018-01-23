package views;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
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

	private static final String BUTTON_CLICK = "CLICK";

	private JLabel label;
	private JTextField searchField;
	private JButton searchBtn;
	private JTable table;

	public PlantPane() {
		super();
		createModels();
		createComponents();
	}

	void createComponents() {
		this.label = new JLabel("Pesquisa por nome:");
		this.searchField = new JTextField();
		this.searchBtn = new JButton("Pesquisar");

		GridBagConstraints cons = new GridBagConstraints();

		cons.gridx = 0;
		cons.gridwidth = 3;
		cons.weightx = 3;
		cons.anchor = GridBagConstraints.FIRST_LINE_START;
		cons.fill = GridBagConstraints.BOTH;
		cons.insets = new Insets(10, 10, 10, 10); // top padding
		add(label, cons);

		cons.gridy = 1;
		add(searchField, cons);

		searchField.addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(KeyEvent e) {
				String s = searchField.getText();
				if (s == null)
					s = "";
				search(s.trim().toLowerCase());
			}

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}
		});

		cons.gridx = 3;
		cons.weightx = 1;
		cons.gridwidth = 1;

		add(searchBtn, cons);

		cons.gridx = 0;
		cons.gridy = 2;
		cons.gridwidth = 4;
		cons.weightx = 4;

		add(new JScrollPane(table), cons);

		searchBtn.setActionCommand(BUTTON_CLICK);
		searchBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals(BUTTON_CLICK)) {
					String s = searchField.getText();
					if (s == null)
						s = "";
					search(searchField.getText().trim().toLowerCase());
				}
			}

		});

	}

	void createModels() {
		this.model = new PlantModel();
		List<Plant> plants = this.model.selectAll();
		this.tableModel = new PlantTableModel(plants, model);
		this.table = new JTable();
		this.table.setModel(this.tableModel);
		this.tableModel.fireTableDataChanged();
		this.tableModel.addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				System.out.println(e);
			}
		});
		;

		Action delete = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				JTable table = (JTable) e.getSource();
				int modelRow = Integer.valueOf(e.getActionCommand());
				((DefaultTableModel) table.getModel()).removeRow(modelRow);
			}
		};

		ButtonColumn buttonColumn = new ButtonColumn(table, delete, 3);
		buttonColumn.setMnemonic(KeyEvent.VK_D);
	}

	void search(String text) {
		System.out.println("->" + text);
		List<Plant> plants = this.model.selectByName(text);
		this.tableModel.setRowCount(0);
		this.tableModel.updateValues(plants);
		this.table.setModel(this.tableModel);
		this.tableModel.fireTableDataChanged();
	}

}
