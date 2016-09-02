package edu.psu.swe.testing.junit5.presentation.models;

public class Engine {
	private EngineType type;
	private boolean running;
	private int RPM;
	private IgnitionStatus ignition;
	
	public enum IgnitionStatus{ON, OFF, ACCESSORIES}
	public enum EngineType{GASOLINE, DIESEL, BIODIESEL, JETFUEL, ELECTRIC}
	
	
	public Engine(EngineType type) {
		super();
		this.type = type;
	}
	
	public EngineType getType() {
		return type;
	}
	public void setType(EngineType type) {
		this.type = type;
	}
	public boolean isRunning() {
		return running;
	}

	public int getRPM() {
		return RPM;
	}
	public void setRPM(int rPM) {
		RPM = rPM;
	}
	public IgnitionStatus getIgnition() {
		return ignition;
	}
	public void setIgnition(IgnitionStatus ignition) {
		this.ignition = ignition;
	}

}
