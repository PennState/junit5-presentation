package edu.psu.swe.testing.junit5.presentation.models;

public abstract class Car {
	private Engine engine;
	private DriveTrain driveTrain;
	private Body body;
	
	
	public Car(Engine engine, DriveTrain driveTrain, Body body) {
		super();
		this.engine = engine;
		this.driveTrain = driveTrain;
		this.body = body;
	}
	
	public Engine getEngine() {
		return engine;
	}

	public DriveTrain getDriveTrain() {
		return driveTrain;
	}

	public Body getBody() {
		return body;
	}


	public abstract void startEngine();
	public abstract void accelerate(int percentIncrease);
	public abstract void idle();
	public abstract void brake();

}
