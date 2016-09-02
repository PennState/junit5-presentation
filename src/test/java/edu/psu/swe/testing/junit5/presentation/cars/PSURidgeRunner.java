package edu.psu.swe.testing.junit5.presentation.cars;

import edu.psu.swe.testing.junit5.presentation.models.Body;
import edu.psu.swe.testing.junit5.presentation.models.Body.BodyStyle;
import edu.psu.swe.testing.junit5.presentation.models.Car;
import edu.psu.swe.testing.junit5.presentation.models.DriveTrain;
import edu.psu.swe.testing.junit5.presentation.models.DriveTrain.DriveType;
import edu.psu.swe.testing.junit5.presentation.models.DriveTrain.DutyType;
import edu.psu.swe.testing.junit5.presentation.models.DriveTrain.TransType;
import edu.psu.swe.testing.junit5.presentation.models.Engine;
import edu.psu.swe.testing.junit5.presentation.models.Engine.EngineType;

public class PSURidgeRunner extends Car{
	private static Engine engine = new Engine(EngineType.BIODIESEL);
	private static DriveTrain drive = new DriveTrain(DriveType.ALL, TransType.MANUAL, DutyType.SPORT);
	private static Body body = new Body(BodyStyle.SPORT, true);
	
	public PSURidgeRunner(){
		super(engine, drive, body);
	}

	@Override
	public void startEngine() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accelerate(int percentIncrease) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void idle() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void brake() {
		// TODO Auto-generated method stub
		
	}
}
