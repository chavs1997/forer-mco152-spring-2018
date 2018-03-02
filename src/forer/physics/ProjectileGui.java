package forer.physics;

import java.awt.*;
import javax.swing.*;

public class ProjectileGui extends JFrame {

	JTextField returnX;
	JTextField returnY;
	public ProjectileGui() {
		setTitle("Projectile Viewer");
		setSize(300, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraint = new GridBagConstraints();
		constraint.gridx = 0;
		constraint.gridy = 0;
		constraint.fill = GridBagConstraints.BOTH;

		panel.add(new JLabel("Angle: "), constraint);

		constraint.gridx = 1;
		JTextField getAngle = new JTextField();
		panel.add(getAngle, constraint);

		constraint.gridx = 0;
		constraint.gridy = 1;
		panel.add(new JLabel("Velocity: "), constraint);

		constraint.gridx = 1;
		JTextField getVelocity = new JTextField();
		panel.add(getVelocity, constraint);

		constraint.gridx = 0;
		constraint.gridy = 2;
		panel.add(new JLabel("Time: "), constraint);

		constraint.gridx = 1;
		JTextField getTime = new JTextField();
		panel.add(getTime, constraint);

		constraint.gridx = 0;
		constraint.gridy = 3;
		constraint.gridwidth = 2;
		panel.add(new JLabel("Coordinates: "), constraint);

		constraint.gridy = 4;
		panel.add(new JLabel("x: "), constraint);

		constraint.gridx = 1;
		returnX = new JTextField();
		panel.add(returnX, constraint);

		constraint.gridx = 0;
		constraint.gridy = 5;
		panel.add(new JLabel("y: "), constraint);

		constraint.gridx = 1;
		constraint.gridy = 5;
		returnY = new JTextField();
		panel.add(returnY, constraint);

		ProjectionListener listenAngle = new ProjectionListener(getAngle, "angle", returnX, returnY);
		getAngle.getDocument().addDocumentListener(listenAngle);

		ProjectionListener listenVelocity = new ProjectionListener(getVelocity, "velocity", returnX, returnY);
		getVelocity.getDocument().addDocumentListener(listenVelocity);

		ProjectionListener listenTime = new ProjectionListener(getTime, "time", returnX, returnY);
		getTime.getDocument().addDocumentListener(listenTime);

		add(panel);

	}

	public static void main(String args[]) {
		new ProjectileGui().setVisible(true);
	}
}
