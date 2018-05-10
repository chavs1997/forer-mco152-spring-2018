package forer.earthquake;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import forer.earthquake.net.USGSEarthquakeService;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class USGSEarthquakeServiceTest {

	@Test
	public void testGetAllMonth() throws IOException {
		Retrofit retrofit = new Retrofit.Builder().baseUrl("https://earthquake.usgs.gov")
				.addConverterFactory(GsonConverterFactory.create()).build();
		USGSEarthquakeService service = retrofit.create(USGSEarthquakeService.class);
		
		Call<EarthquakeFeed> call = service.getAllMonth();
		Response<EarthquakeFeed> response = call.execute();
		
		List<Earthquake> features = response.body().getFeatures();
		assertTrue(features.size() > 0);
		assertTrue(features.get(0).getProperties().getMag() > 0);
		assertNotNull(features.get(0).getProperties().getPlace());
	}

}
