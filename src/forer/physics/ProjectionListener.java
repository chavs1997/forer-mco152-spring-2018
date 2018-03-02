package forer.physics;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ProjectionListener implements DocumentListener {

	JTextField textField;
	JTextField returnX;
	JTextField returnY;
	String type = null;
	Projectile proj = new Projectile(0, 0);
	int time;

	public ProjectionListener(JTextField textField, String type, JTextField returnX, JTextField returnY) {
		this.textField = textField;
		this.returnX = returnX;
		this.returnY = returnY;
		this.type = type;
	}

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
		Double value = Double.parseDouble(textField.getText().trim());
		if (type.equalsIgnoreCase("angle")) {
			proj.setAngle(value);			
		}

		if (type.equalsIgnoreCase("velocity")) {
			proj.setVelocity(value);
		}

		if (type.equalsIgnoreCase("time")) {
			time = Integer.parseInt(textField.getText());
		}
		returnX.setText(Double.toString(proj.getX(time)));
		returnY.setText(Double.toString(proj.getY(time)));

	}
}