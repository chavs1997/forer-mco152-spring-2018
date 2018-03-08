package forer.vending;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VendingGUI extends JFrame {
	public VendingGUI() {
		setTitle("Vending Machine");
		setSize(300, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setBackground(Color.ORANGE);
		GridBagConstraints constraint = new GridBagConstraints();
		constraint.gridx = 0;
		constraint.gridy = 0;
		constraint.fill = GridBagConstraints.BOTH;

		panel.add(new JLabel("Price"), constraint);
		constraint.gridy = 1;
		panel.add(new JLabel("Paid"), constraint);
		constraint.gridy = 2;
		panel.add(new JLabel("Change"), constraint);
		constraint.gridy = 3;
		panel.add(new JLabel("   Quarters: "), constraint);
		constraint.gridy = 4;
		panel.add(new JLabel("   Dimes: "), constraint);
		constraint.gridy = 5;
		panel.add(new JLabel("   Nickels: "), constraint);
		constraint.gridy = 6;
		panel.add(new JLabel("   Pennies: "), constraint);

		constraint.gridy = 0;
		constraint.gridx = 1;
		JTextField price = new JTextField("Enter price here");
		panel.add(price, constraint);
		JTextField paid = new JTextField("Enter amount paid here");
		constraint.gridy = 1;
		panel.add(paid, constraint);

		JTextField quarters = new JTextField();
		constraint.gridy = 3;
		panel.add(quarters, constraint);
		JTextField dimes = new JTextField();
		constraint.gridy = 4;
		panel.add(dimes, constraint);
		JTextField nickels = new JTextField();
		constraint.gridy = 5;
		panel.add(nickels, constraint);
		JTextField pennies = new JTextField();
		constraint.gridy = 6;
		panel.add(pennies, constraint);

		JButton button = new JButton("Make Change");
		VendingMachine vend = new VendingMachine();
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Change chan = new Change();
				chan = vend.pay(Double.parseDouble(paid.getText()), Double.parseDouble(price.getText()));
				quarters.setText(Integer.toString(chan.getNumOfQuarters()));
				dimes.setText(Integer.toString(chan.getNumOfDimes()));
				nickels.setText(Integer.toString(chan.getNumOfNickels()));
				pennies.setText(Integer.toString(chan.getNumOfPennies()));
			}

		});
		constraint.gridy = 2;
		panel.add(button, constraint);

		add(panel);

	}

	public static void main(String[] args) {
		new VendingGUI().setVisible(true);
	}
}
