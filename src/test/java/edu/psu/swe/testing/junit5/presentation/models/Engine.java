package edu.psu.swe.testing.junit5.presentation.models;

public abstract class Engine {
	protected static EngineType type;
	protected boolean running;
	protected int RPM = 0;
	protected static int idle;
	protected IgnitionStatus ignition;
	
	public enum IgnitionStatus{ON, OFF, ACCESSORIES}
	public enum EngineType{GASOLINE, DIESEL, BIODIESEL, TOP_FUEL, ELECTRIC}
	
	
	public Engine(EngineType type) {
		Engine.type = type;
	}
	
	public EngineType getType() {
		return type;
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

	public abstract void startEngine();
	public abstract void stopEngine();

	public int getIdle() {
		return idle;
	}

}
