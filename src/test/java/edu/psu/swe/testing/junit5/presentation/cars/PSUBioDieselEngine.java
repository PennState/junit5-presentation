package edu.psu.swe.testing.junit5.presentation.cars;

import edu.psu.swe.testing.junit5.presentation.models.Engine;

public class PSUBioDieselEngine extends Engine{

	public PSUBioDieselEngine() {
		super(EngineType.BIODIESEL);
	}

	@Override
	public void startEngine() {
		setRPM(500);
		
	}

	@Override
	public void stopEngine() {
		//Ooops. The engine didn't stop. This should be caught in tests.
		setRPM(500);
		
	}
	
	

}
