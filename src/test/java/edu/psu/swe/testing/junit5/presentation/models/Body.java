package edu.psu.swe.testing.junit5.presentation.models;

public class Body {

	private BodyStyle style;
	private boolean convertable;
	private int suspenTravel;
	private int velocity;
	
	public enum BodyStyle{TRUCK, SEDAN, SPORT}
	
	public Body(BodyStyle style, boolean convertable) {
		super();
		this.style = style;
		this.convertable = convertable;
	}

	
	public BodyStyle getStyle() {
		return style;
	}

	public void setStyle(BodyStyle style) {
		this.style = style;
	}

	public boolean isConvertable() {
		return convertable;
	}

	public int getSuspenTravel() {
		return suspenTravel;
	}

	public void setSuspenTravel(int suspenTravel) {
		this.suspenTravel = suspenTravel;
	}

	public int getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}


}
