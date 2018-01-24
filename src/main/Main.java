package main;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import controllers.MainController;

public class Main {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MainController();
			}
		});
	}

}
