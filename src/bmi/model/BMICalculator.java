package bmi.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import bmi.exception.ImpossibleHeightException;
import bmi.exception.ImpossibleWeightException;

public class BMICalculator {

	// metric units
	double height; // meters
	double weight; // kilograms

	public BMICalculator() {
		super();
	}

	public double calculateBMI() throws ImpossibleWeightException, ImpossibleHeightException {
		if (weight == 0f) {
			throw new ImpossibleWeightException("No weight supplied");
		}
		if (height == 0f) {
			throw new ImpossibleHeightException("No height supplied");
		}
		return weight / (height * height);
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double h) throws ImpossibleHeightException {
		if (h < 1.0 || h > 2.5) {
			throw new ImpossibleHeightException("Specified height not reasonable for an adult");
		}
		this.height = h;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double d) throws ImpossibleWeightException {
		if (d < 20.0 || d > 200.0) {
			throw new ImpossibleWeightException("Specified weight not reasonable for an adult");
		}
		this.weight = d;
	}
	
	public static String getDescription(double bmi) {
		String description = "No description";
		long lbmi = Math.round(bmi);
		for (BMIRanges range : BMIRanges.values()) {
			if ( lbmi <= range.getTop() ) {
				return range + ": " + range.getDescription();
			}
		}
		// the following line should never be reached
		return description;
	}

	// main method to test calculations
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BMICalculator bmic = new BMICalculator();
		// try a set of measurements in metric
		System.out.println("Test a BMI for metric input");
		try {
			// read a height in centimeters
			System.out.print("Enter a height in centimeters: ");
			String sheight = reader.readLine().trim();
			double height = Double.parseDouble(sheight);
			bmic.setHeight(height / 100f);
			// read a weight in kilograms
			System.out.print("Enter a weight in kilograms: ");
			String sweight = reader.readLine().trim();
			double weight = Double.parseDouble(sweight);
			bmic.setWeight(weight);
			double bmi = bmic.calculateBMI();
			System.out.println(
					"BMI for " + weight + " kg and " + height + " meters is " + bmi );
			System.out.println("How to interpret this BMI value");
			System.out.println(BMICalculator.getDescription(bmi));
		} catch (Exception e) {
			System.out.println(e);
		}
		// try a set of measurements in metric
		System.out.println();
		System.out.println("Test a BMI for US standard input");
		try {
			// read a height in inches
			System.out.print("Enter a height in inches: ");
			String sheight = reader.readLine().trim();
			double height = Double.parseDouble(sheight);
			bmic.setHeight(MetricConverter.inchToMeter(height));
			// read a weight in kilograms
			System.out.print("Enter a weight in pounds: ");
			String sweight = reader.readLine().trim();
			double weight = Double.parseDouble(sweight);
			bmic.setWeight(MetricConverter.poundToKg(weight));
			double bmi = bmic.calculateBMI();
			System.out.println(
					"BMI for " + weight + " pounds and " + height + " inches is " + bmi );
			System.out.println("How to interpret this BMI value");
			System.out.println(BMICalculator.getDescription(bmi));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}