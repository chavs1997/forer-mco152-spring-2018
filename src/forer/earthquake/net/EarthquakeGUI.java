package forer.earthquake.net;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

import forer.earthquake.*;
import retrofit2.*;
import retrofit2.converter.gson.GsonConverterFactory;

public class EarthquakeGUI extends JFrame {

	Retrofit retrofit = new Retrofit.Builder().baseUrl("https://earthquake.usgs.gov")
			.addConverterFactory(GsonConverterFactory.create()).build();

	USGSEarthquakeService service = retrofit.create(USGSEarthquakeService.class);

	JLabel enterMonthMag = new JLabel();
	JLabel enterWeekMag = new JLabel();
	JLabel enterDayMag = new JLabel();
	JLabel enterHourMag = new JLabel();
	JLabel enterMonthLoc = new JLabel();
	JLabel enterWeekLoc = new JLabel();
	JLabel enterDayLoc = new JLabel();
	JLabel enterHourLoc = new JLabel();

	public EarthquakeGUI() {
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

		getMonthEarthquake();
		getWeekEarthquake();
		getDayEarthquake();
		getHourEarthquake();

		JButton button = new JButton("Refresh");
		button.addActionListener(e -> {
			getMonthEarthquake();
			getWeekEarthquake();
			getDayEarthquake();
			getHourEarthquake();
		});

		homePanel.add(mainPanel);
		homePanel.add(button);
		add(homePanel);
	}

	public void getHourEarthquake() {
		Call<EarthquakeFeed> call = service.getAllHour();
		call.enqueue(new Callback<EarthquakeFeed>() {

			@Override
			public void onFailure(Call<EarthquakeFeed> call, Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onResponse(Call<EarthquakeFeed> call, Response<EarthquakeFeed> response) {
				EarthquakeFeed feed = response.body();
				Earthquake largest = feed.getLargest();
				enterHourMag.setText(String.valueOf(largest.getProperties().getMag()));
				enterHourLoc.setText(String.valueOf(largest.getProperties().getPlace()));
			}

		});
	}

	public void getDayEarthquake() {
		Call<EarthquakeFeed> call = service.getAllDay();
		call.enqueue(new Callback<EarthquakeFeed>() {

			@Override
			public void onFailure(Call<EarthquakeFeed> call, Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onResponse(Call<EarthquakeFeed> call, Response<EarthquakeFeed> response) {
				EarthquakeFeed feed = response.body();
				Earthquake largest = feed.getLargest();
				enterDayMag.setText(String.valueOf(largest.getProperties().getMag()));
				enterDayLoc.setText(String.valueOf(largest.getProperties().getPlace()));
			}

		});
	}

	public void getWeekEarthquake() {
		Call<EarthquakeFeed> call = service.getAllWeek();
		call.enqueue(new Callback<EarthquakeFeed>() {

			@Override
			public void onFailure(Call<EarthquakeFeed> call, Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onResponse(Call<EarthquakeFeed> call, Response<EarthquakeFeed> response) {
				EarthquakeFeed feed = response.body();
				Earthquake largest = feed.getLargest();
				enterWeekMag.setText(String.valueOf(largest.getProperties().getMag()));
				enterWeekLoc.setText(String.valueOf(largest.getProperties().getPlace()));
			}

		});
	}

	public void getMonthEarthquake() {

		Call<EarthquakeFeed> call = service.getAllMonth();
		call.enqueue(new Callback<EarthquakeFeed>() {

			@Override
			public void onFailure(Call<EarthquakeFeed> call, Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onResponse(Call<EarthquakeFeed> call, Response<EarthquakeFeed> response) {
				EarthquakeFeed feed = response.body();
				Earthquake largest = feed.getLargest();
				enterMonthMag.setText(String.valueOf(largest.getProperties().getMag()));
				enterMonthLoc.setText(String.valueOf(largest.getProperties().getPlace()));
			}

		});

	}

	public static void main(String[] args) {
		new EarthquakeGUI().setVisible(true);
	}

}
