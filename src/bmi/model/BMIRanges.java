package bmi.model;

public enum BMIRanges {
	UNDERWEIGHT(0D, 18.5D), NORMAL_WEIGHT(18.5D, 25D), OVERWEIGHT(25D, 30D), OBESITY(30D, 100D);

	private double bottom;
	private double top;

	BMIRanges(double bottom, double top) {
		setBottom(bottom);
		setTop(top);
	}

	public double getBottom() {
		return bottom;
	}

	private void setBottom(double bottom) {
		this.bottom = bottom;
	}

	public double getTop() {
		return top;
	}

	private void setTop(double top) {
		this.top = top;
	}

	public String getDescription() {
		String description = "BMI values at least " + bottom;
		if (!this.equals(OBESITY)) {
			description += " and up to " + top;
		}
		return description;
	}
}
