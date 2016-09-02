package edu.psu.swe.testing.junit5.presentation.interfaces;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import edu.psu.swe.testing.junit5.presentation.cars.PSUBioDieselEngine;
import edu.psu.swe.testing.junit5.presentation.models.Car;
import edu.psu.swe.testing.junit5.presentation.models.Engine;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

@Disabled
public interface EngineTests{
	
	Engine buildEngine();
	
	abstract boolean isEngineRunning();
	abstract void startEngine();
	abstract void stopEngine();
	abstract int getRPM();
	abstract int addFuel(int percentIncrease);
	abstract int reduceFuel(int percentDecrease);
	abstract void hitKillSwitch();
	 
	
	@BeforeEach
	default void startEngineTest(){
		Engine engine = buildEngine();
		engine.startEngine();
		assertTrue(isEngineRunning(), "Engine failed to start.");
	}
	
	@AfterEach
	default void stopEngineTest(){
		stopEngine();
		assertFalse(isEngineRunning(), "Engine failed to stop. Current RPM is " + getRPM() + ".");
	}
	
	@Test
	default void addFuelTest(){
		int idleRpm = getRPM();
		addFuel(100);
		assertTrue(getRPM() > idleRpm, "Check RPMs with 100% fuel increase. Current RPM is " + getRPM());	
	}
	
	@Test
	default void removeFuelTest(){
		int idleRpm = getRPM();
		reduceFuel(50);
		assertTrue(getRPM() < idleRpm, "Check RPMs with 50% fuel decrease. Current RPM is " + getRPM());	
	}

	//TODO: Add conditionally disable. Only drag cars and motorcycles have manual kill switches.
	@Test
	//Is this where the conditional disabling goes?
	default void killSwitchTest(){
		assertTrue(isEngineRunning(), "Engine not running.");
		hitKillSwitch();
		assertFalse(isEngineRunning(), "Engine should had stopped with killswitch. Current RPM is " + getRPM());
	}
	
	//TODO: Add long running annotation
	@Test
	default void runTillFailure(){
		//Some really, really long test
	}

}