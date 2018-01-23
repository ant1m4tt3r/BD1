package controllers;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import db.Connection;
import views.EquipmentPane;
import views.FoodPane;
import views.PlantPane;
import views.UserPane;

public class MainController extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTabbedPane mainPane;

	public MainController() {
		super("Planta de Secagem de Alimentos");
		startComponents();
	}

	private void startComponents() {
		/**************************************
		 ******** INITIAL FRAME CONFIGS *******
		 *************************************/
		setSize(600, 400);

		/*********************************
		 ******* CREATE COMPONENTS *******
		 ********************************/
		mainPane = new JTabbedPane();

		/*********************************
		 ********* ADD COMPONENTS ********
		 ********************************/
		addPanes();
		add(mainPane);

		/**************************************
		 ********* FINAL FRAME CONFIGS ********
		 *************************************/
//		addWindowListener(new WindowAdapter() {
//			public void windowClosing(WindowEvent winEvt) {
//				// Connection.getInstance().closeConnection();
//				System.exit(0);
//			}
//		});
		centreWindow(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	public void addPanes() {
		mainPane.add("Planta", new PlantPane());
		mainPane.add("Equipamentos", new EquipmentPane());
		mainPane.add("Alimentos", new FoodPane());
		mainPane.add("Usuários", new UserPane());
	}

	public static void centreWindow(JFrame frame) {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		int y = 50;
		frame.setLocation(x, y);
	}

}
