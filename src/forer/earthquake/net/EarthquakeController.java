package forer.earthquake.net;

import javax.swing.JLabel;

import com.google.inject.Inject;

import forer.earthquake.*;
import retrofit2.*;

public class EarthquakeController {

	private EarthquakeView view;
	private USGSEarthquakeService service;

	@Inject
	public EarthquakeController(EarthquakeView view, USGSEarthquakeService service) {
		this.view = view;
		this.service = service;
	}

	public void refreshData() {
		requestMonth();
		requestWeek();
		requestDay();
		requestHour();
	}

	public void requestHour() {
		requestEarthquakeFeed(service.getAllHour(), view.getHourMagLabel(), view.getHourLocLabel());
	}

	public void requestDay() {
		requestEarthquakeFeed(service.getAllDay(), view.getDayMagLabel(), view.getDayLocLabel());
	}

	public void requestWeek() {
		requestEarthquakeFeed(service.getAllWeek(), view.getWeekMagLabel(), view.getWeekLocLabel());
	}

	public void requestMonth() {

		requestEarthquakeFeed(service.getAllMonth(), view.getMonthMagLabel(), view.getMonthLocLabel());
	}

	public void requestEarthquakeFeed(Call<EarthquakeFeed> call, JLabel mag, JLabel loc) {
		call.enqueue(new Callback<EarthquakeFeed>() {

			@Override
			public void onFailure(Call<EarthquakeFeed> call, Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onResponse(Call<EarthquakeFeed> call, Response<EarthquakeFeed> response) {
				EarthquakeFeed feed = response.body();
				showLargestEarthquake(feed, mag, loc);
			}

		});
	}

	public void showLargestEarthquake(EarthquakeFeed feed, JLabel mag, JLabel loc) {
		Earthquake largest = feed.getLargest();
		mag.setText(String.valueOf(largest.getProperties().getMag()));
		loc.setText(String.valueOf(largest.getProperties().getPlace()));
	}
}
