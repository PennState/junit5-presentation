package edu.psu.swe.testing.junit5.presentation.models;

public class DriveTrain {

	private DriveType drive;
	private TransType trans;
	private DutyType duty;
	
	public enum DriveType{FRONT, REAR, ALL, FOUR}
	public enum TransType{AUTO, MANUAL, SEMI_AUTO}
	public enum DutyType{HEAVY, STANDARD, SPORT}
	
	
	public DriveTrain(DriveType drive, TransType trans, DutyType duty) {
		super();
		this.drive = drive;
		this.trans = trans;
		this.duty = duty;
	}
	public DriveType getDrive() {
		return drive;
	}
	public void setDrive(DriveType drive) {
		this.drive = drive;
	}
	public DutyType getDuty() {
		return duty;
	}
	public void setDuty(DutyType duty) {
		this.duty = duty;
	}
	public TransType getTrans() {
		return trans;
	}
	public void setTrans(TransType trans) {
		this.trans = trans;
	}
	
	
}
