package edu.psu.swe.testing.junit5.presentation.interfaces;

import org.junit.jupiter.api.Disabled;

import edu.psu.swe.testing.junit5.presentation.cars.PSUBioDieselEngine;
import edu.psu.swe.testing.junit5.presentation.models.Engine;

@Disabled
public class PSUBioDieselEngineTests implements BioDieselTests {

	//int rpm = 0;
	Engine engine;
	
	@Override
	public Engine buildEngine() {
		engine = new PSUBioDieselEngine();
		return engine;
	}
	
	public boolean isEngineRunning() {
		if (engine.getRPM() > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void startEngine() {
		engine.startEngine();
	}

	@Override
	public void stopEngine() {
		//Bad logic will pass some tests but not all.
		//rpm = rpm - 500;

	}

	@Override
	public int getRPM() {
		//return rpm;
		return 0;
	}

	@Override
	public int addFuel(int percentIncrease) {
		//rpm += (int)(rpm*(percentIncrease/100.0f));	
		//return rpm;
		return 0;
	}

	@Override
	public int reduceFuel(int percentDecrease) {
		//rpm -= (int)(rpm*(percentDecrease/100.0f));	
		//return rpm;
		return 0;
	}

	@Override
	//Can we conditionally disable this method since only drag cars and motorcycles have manual kill switches?
	public void hitKillSwitch() {
		
	}


}
