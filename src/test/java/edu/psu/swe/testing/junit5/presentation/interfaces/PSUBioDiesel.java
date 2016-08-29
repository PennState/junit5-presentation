package edu.psu.swe.testing.junit5.presentation.interfaces;

public class PSUBioDiesel implements EngineTests {

	int rpm = 0;

	@Override
	public Object createCar() {
		// Build a car object
		return null;
	}

	@Override
	public Object createEngineTests() {
		// Create a biodiesel engine
		return null;
	}

	@Override
	public boolean isEngineRunning() {
		if (rpm > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void startEngine() {
		rpm = 500;
	}

	@Override
	public void stopEngine() {
		//Bad logic will pass some tests but not all.
		rpm = rpm - 500;

	}

	@Override
	public int getRPM() {
		return rpm;
	}

	@Override
	public int addFuel(int percentIncrease) {
		rpm += (int)(rpm*(percentIncrease/100.0f));	
		return rpm;
	}

	@Override
	public int reduceFuel(int percentDecrease) {
		rpm -= (int)(rpm*(percentDecrease/100.0f));	
		return rpm;
	}

	@Override
	//Can we conditionally disable this method since only drag cars and motorcycles have manual kill switches?
	public void hitKillSwitch() {
		
	}
}
