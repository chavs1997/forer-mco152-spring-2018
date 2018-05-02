package forer.earthquake.net;

import java.awt.*;
import javax.swing.*;
import retrofit2.*;
import retrofit2.converter.gson.GsonConverterFactory;

public class EarthquakeView extends JFrame {

	private JLabel enterMonthMag = new JLabel();
	private JLabel enterWeekMag = new JLabel();
	private JLabel enterDayMag = new JLabel();
	private JLabel enterHourMag = new JLabel();
	private JLabel enterMonthLoc = new JLabel();
	private JLabel enterWeekLoc = new JLabel();
	private JLabel enterDayLoc = new JLabel();
	private JLabel enterHourLoc = new JLabel();

	public EarthquakeView() {
		setTitle("Highest Magnitude Earthquakes");
		setSize(500, 350);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel homePanel = new JPanel();
		homePanel.setLayout(new BoxLayout(homePanel, BoxLayout.Y_AXIS));
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridBagLayout());
		GridBagConstraints constraint = new GridBagConstraints();
		constraint.gridx = 0;
		constraint.gridy = 0;
		constraint.fill = GridBagConstraints.BOTH;
		constraint.insets = new Insets(3, 2, 3, 2);

		constraint.gridy = 1;
		mainPanel.add(new JLabel("Past Month: "), constraint);
		constraint.gridy = 2;
		mainPanel.add(new JLabel("Past Week: "), constraint);
		constraint.gridy = 3;
		mainPanel.add(new JLabel("Past Day: "), constraint);
		constraint.gridy = 4;
		mainPanel.add(new JLabel("Past Hour: "), constraint);
		constraint.gridx = 1;
		constraint.gridy = 0;
		mainPanel.add(new JLabel("Magnitude   "), constraint);
		constraint.gridy = 1;
		mainPanel.add(enterMonthMag, constraint);
		constraint.gridy = 2;
		mainPanel.add(enterWeekMag, constraint);
		constraint.gridy = 3;
		mainPanel.add(enterDayMag, constraint);
		constraint.gridy = 4;
		mainPanel.add(enterHourMag, constraint);
		constraint.gridx = 2;
		constraint.gridy = 0;
		mainPanel.add(new JLabel("   Location   "), constraint);
		constraint.gridy = 1;
		mainPanel.add(enterMonthLoc, constraint);
		constraint.gridy = 2;
		mainPanel.add(enterWeekLoc, constraint);
		constraint.gridy = 3;
		mainPanel.add(enterDayLoc, constraint);
		constraint.gridy = 4;
		mainPanel.add(enterHourLoc, constraint);

		Retrofit retrofit = new Retrofit.Builder().baseUrl("https://earthquake.usgs.gov")
				.addConverterFactory(GsonConverterFactory.create()).build();

		USGSEarthquakeService service = retrofit.create(USGSEarthquakeService.class);
		EarthquakeController controller = new EarthquakeController(this, service);
		controller.refreshData();

		JButton button = new JButton("Refresh");
		button.addActionListener(e -> {
			controller.refreshData();
		});

		homePanel.add(mainPanel);
		homePanel.add(button);
		add(homePanel);
	}

	public static void main(String[] args) {
		new EarthquakeView().setVisible(true);
	}

	public JLabel getHourMagLabel() {
		return enterHourMag;
	}

	public JLabel getHourLocLabel() {
		return enterHourLoc;
	}

	public JLabel getDayMagLabel() {
		return enterDayMag;
	}

	public JLabel getDayLocLabel() {
		return enterDayLoc;
	}

	public JLabel getWeekMagLabel() {
		return enterWeekMag;
	}

	public JLabel getWeekLocLabel() {
		return enterWeekLoc;
	}

	public JLabel getMonthMagLabel() {
		return enterMonthMag;
	}

	public JLabel getMonthLocTextField() {
		return enterMonthLoc;
	}

}
