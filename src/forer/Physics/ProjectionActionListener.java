package forer.Physics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class ProjectionActionListener implements ActionListener {

	JTextField textField = new JTextField();

	public ProjectionActionListener(JTextField textField) {
		this.textField = textField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		textField.setText("ActionPerformed");
	}

}
