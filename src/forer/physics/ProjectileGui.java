package forer.physics;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ProjectileGui extends JFrame {

	JTextField returnX;
	JTextField returnY;

	public ProjectileGui() {
		setTitle("Projectile Viewer");
		setSize(500, 200);
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

		DocumentListener listen = new DocumentListener() {

			@Override
			public void changedUpdate(DocumentEvent e) {
				change(e);
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				change(e);
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				change(e);
			}

			public void change(DocumentEvent e) {
				Projectile proj = new Projectile(0, 0);
				if (!getAngle.getText().isEmpty() && !getVelocity.getText().isEmpty() && !getTime.getText().isEmpty()) {
					double angle = Double.parseDouble(getAngle.getText());
					double velocity = Double.parseDouble(getVelocity.getText());
					int time = Integer.parseInt(getTime.getText());
					proj.setAngle(angle);
					proj.setVelocity(velocity);
					returnX.setText(Double.toString(proj.getX(time)));
					returnY.setText(Double.toString(proj.getY(time)));

				}

			}
		};
		
		getAngle.getDocument().addDocumentListener(listen);
		getVelocity.getDocument().addDocumentListener(listen);
		getTime.getDocument().addDocumentListener(listen);

		add(panel);

	}

	public static void main(String args[]) {
		new ProjectileGui().setVisible(true);
	}
}
