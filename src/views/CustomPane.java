package views;

import java.awt.GridBagLayout;

import javax.swing.JPanel;

import models.Model;
import models.beans.Bean;
import models.table.CustomTableModel;

public abstract class CustomPane<T extends Bean> extends JPanel {

	private static final long serialVersionUID = 1L;
	
	protected CustomTableModel<T> tableModel = null;
	protected Model<T> model;

	public CustomPane() {
		super(new GridBagLayout());
	}

	abstract void createComponents();
	
	abstract void createModels();
	
	abstract void search(String text);

}
