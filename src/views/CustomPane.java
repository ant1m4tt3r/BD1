package views;

import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.table.AbstractTableModel;

import models.Model;
import models.beans.Plant;

public abstract class CustomPane extends JPanel {

	private static final long serialVersionUID = 1L;
	
	protected AbstractTableModel tableModel = null;
	protected Model<Plant> model;

	public CustomPane() {
		super(new GridBagLayout());
	}

	abstract void createComponents();
	
	abstract void createModels();
	
	abstract void search(String text);

}
