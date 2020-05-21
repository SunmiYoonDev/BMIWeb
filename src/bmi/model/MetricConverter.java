package bmi.model;

public class MetricConverter {

	public MetricConverter() {		
	}
	
	public static double inchToMeter(double inches) {
		return inches * .0254D;
	}
	public static double poundToKg(double pounds) {
		return pounds / 2.2046D; 
	}

}
