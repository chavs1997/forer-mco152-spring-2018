package forer.earthquake;

import java.util.List;

public class EarthquakeFeed {
	
	private String type;
	private List<Earthquake> features;

	
	public List<Earthquake> getFeatures() {
		return features;
	}


	public String getType() {
		return type;
	}
	
}
