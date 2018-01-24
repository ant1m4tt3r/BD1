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

import models.Model;
import models.beans.Bean;
import models.table.CustomTableModel;

public abstract class CustomPane<T extends Bean> extends JPanel {

	protected static final long serialVersionUID = 1L;

	protected static final String BUTTON_SEARCH = "CLICK";
	protected static final String BUTTON_INSERT = "INSERT";

	protected boolean initializing = false;

	protected JLabel label;
	protected JTextField searchField;
	protected JButton searchBtn;
	protected JButton insertBtn;

	protected CustomTableModel<T> tableModel = null;
	protected JTable table = null;
	protected Model<T> model;

	public CustomPane(String relation) {
		super(new GridBagLayout());
		createModels();
		createComponents(relation);
	}

	abstract void createModels();

	abstract void showInsertNewPlantModal();

	void createComponents(String relation) {
		this.label = new JLabel("Pesquisa por nome:");
		this.searchField = new JTextField();
		this.searchBtn = new JButton("Pesquisar");
		this.insertBtn = new JButton("Cadastrar " + relation);

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
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String s = searchField.getText();
					if (s == null)
						s = "";
					search(s.trim().toLowerCase());
				}
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

		searchBtn.setActionCommand(BUTTON_SEARCH);
		searchBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals(BUTTON_SEARCH)) {
					String s = searchField.getText();
					if (s == null)
						s = "";
					search(searchField.getText().trim().toLowerCase());
				}
			}

		});

		cons.gridx = 0;
		cons.gridy = 3;
		cons.gridwidth = 4;
		cons.weightx = 4;
		add(insertBtn, cons);

		insertBtn.setActionCommand(BUTTON_INSERT);
		insertBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals(BUTTON_INSERT)) {
					showInsertNewPlantModal();
				}
			}

		});

	}

	void search(String text) {
		List<T> plants = this.model.selectByName(text);
		this.tableModel.setRowCount(0);
		this.tableModel.updateValues(plants);
		this.table.setModel(this.tableModel);
		this.tableModel.fireTableDataChanged();
	}

}
