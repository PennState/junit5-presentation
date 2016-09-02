package edu.psu.swe.testing.junit5.presentation.interfaces;

import org.junit.jupiter.api.Disabled;

import edu.psu.swe.testing.junit5.presentation.models.Engine;

@Disabled
public class BioDieselEngineTests implements EngineTests{

	@Override
	public Engine buildEngine() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEngineRunning() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void startEngine() {
		// TODO Auto-generated method stub
		
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
