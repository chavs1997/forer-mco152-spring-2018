package forer.physics;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ProjectileGraphGUI extends JFrame {

	public ProjectileGraphGUI() {

		setTitle("Projectile Viewer");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(0, 2));

		AnimatedProjectileGraph projectileGraph = new AnimatedProjectileGraph();
		panel.add(projectileGraph, BorderLayout.CENTER);

		setContentPane(panel);

		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					projectileGraph.repaint();
				}
			}

		});
		thread.start();
	}

	public static void main(String args[]) {
		new ProjectileGraphGUI().setVisible(true);
	}

}