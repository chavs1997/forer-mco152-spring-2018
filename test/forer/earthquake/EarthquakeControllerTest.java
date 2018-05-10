package forer.earthquake;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import org.junit.Test;
import org.mockito.Mockito;
import forer.earthquake.net.*;
import retrofit2.Call;

public class EarthquakeControllerTest {

	@Test
	public void testRefreshData() {
		EarthquakeView view = Mockito.mock(EarthquakeView.class);
		USGSEarthquakeService service = Mockito.mock(USGSEarthquakeService.class);
		EarthquakeController controller = new EarthquakeController(view, service);
		Call<EarthquakeFeed> call = Mockito.mock(Call.class);
		Mockito.when(service.getAllMonth()).thenReturn(call);
		JLabel label = Mockito.mock(JLabel.class);
		Mockito.when(view.getMonthLocLabel()).thenReturn(label);
		controller.requestMonth();
		assertFalse(view.getMonthLocLabel().getText().equals(""));
	}
	
	
	@Test
	public void testShowLargestEarthquake() {
		
		EarthquakeView view = Mockito.mock(EarthquakeView.class);
		USGSEarthquakeService service = Mockito.mock(USGSEarthquakeService.class);
		EarthquakeController controller = new EarthquakeController(view, service);
		JLabel mag = Mockito.mock(JLabel.class);
		JLabel loc = Mockito.mock(JLabel.class);
		
		List<Earthquake> list = new ArrayList<Earthquake>();
		list.add(new Earthquake(2, "touro Brooklyn", 1));
		list.add(new Earthquake(5, "touro Manhattan", 2));
		
		EarthquakeFeed feed = new EarthquakeFeed("", list);
		controller.showLargestEarthquake(feed, mag, loc);
		
		Mockito.verify(mag).setText("5.0");
		
	}

}
