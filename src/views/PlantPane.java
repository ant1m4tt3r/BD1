package views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import models.Model;
import models.PlantModel;
import models.beans.Plant;
import models.table.PlantTableModel;
import services.PlantService;

public class PlantPane extends CustomPane {

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
		this.table = new JTable(tableModel);
		this.tableModel.addTableModelListener(new TableModelListener() {

			public void tableChanged(TableModelEvent e) {
				System.out.println(e);
			}
			
		});

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
				System.out.println("ACTION");
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
		this.tableModel = new PlantTableModel(this.model.selectAll(), model);
	}

	void search(String text) {
		this.tableModel = new PlantTableModel(this.model.selectByName(text), this.model);
		this.table.setModel(this.tableModel);
	}

}
