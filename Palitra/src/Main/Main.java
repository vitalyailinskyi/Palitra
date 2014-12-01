package Main;

import java.awt.Color;
import java.awt.Frame;

public class Main {

	public static void main(String[] args) {
		Frame f = new Window("Palitra - Ilinskyi");
		f.setVisible(true);
		f.setSize(400, 400);
		f.setLocation(300, 200);
		f.setResizable(true);
		f.setBackground(new Color(96, 96, 96));
	}

}
