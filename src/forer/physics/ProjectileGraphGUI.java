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
		panel.setLayout(new BorderLayout(0,2));
		
		ProjectileGraph projectileGraph = new ProjectileGraph();
		panel.add(projectileGraph, BorderLayout.CENTER);
			
		setContentPane(panel);
	}
	
	
	public static void main(String args[]) {
		new ProjectileGraphGUI().setVisible(true);
	}
	
}