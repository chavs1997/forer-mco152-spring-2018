package forer.physics;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ProjectileGui extends JFrame {
	private JTextField textField;

	public ProjectileGui() {
		setTitle("Projectile Viewer");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		JPanel northPanel = new JPanel();

		panel.setLayout(new BorderLayout());
		northPanel.add(new JLabel("Hello World"));
		northPanel.add(new JLabel("Goodbye World"));
		panel.add(northPanel, BorderLayout.NORTH);

		textField = new JTextField("Text Field");
		panel.add(textField, BorderLayout.WEST);

		JButton button = new JButton("Button");

		button.addActionListener(this::changeTextField);
		panel.add(button, BorderLayout.CENTER);
		panel.add(new JLabel("Can we take a break?"), BorderLayout.SOUTH);
		add(panel);
	}

	public void changeTextField(ActionEvent e) {
		textField.setText("ActionPerformed");
	}

	public static void main(String args[]) {
		new ProjectileGui().setVisible(true);
	}
}
