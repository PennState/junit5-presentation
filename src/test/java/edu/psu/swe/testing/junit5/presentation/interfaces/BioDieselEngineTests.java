package edu.psu.swe.testing.junit5.presentation.interfaces;

import org.junit.jupiter.api.Disabled;

import edu.psu.swe.testing.junit5.presentation.cars.PSUBioDieselEngine;
import edu.psu.swe.testing.junit5.presentation.models.Engine;
import edu.psu.swe.testing.junit5.presentation.models.Engine.IgnitionStatus;

@Disabled
public class BioDieselEngineTests implements EngineTests{

	Engine engine;
	
	@Override
	public Engine buildEngine() {
		//engine = new PSUBioDieselEngine();
		return engine;
	}

	@Override
	public boolean isEngineRunning() {
		return engine.isRunning();
	}

	@Override
	public void startEngine() {
		engine.startEngine();
		
		
	}

	@Override
	public void stopEngine() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getRPM() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addFuel(int percentIncrease) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int reduceFuel(int percentDecrease) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void hitKillSwitch() {
		// TODO Auto-generated method stub
		
	}



}
