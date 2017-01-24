package org.usfirst.frc.team5030.robot;

import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Servo;

public class RobotMap 
{
	//Front Talon in the left transmission ID = 0
	public static final TalonSRX FLSRX = new TalonSRX(0);
	
	//Back Talon in the left transmission ID = 1
	public static final TalonSRX BLSRX = new TalonSRX(1);
	
	//Front Talon in the right transmission ID = 2
	public static final TalonSRX FRSRX = new TalonSRX(2);
	
	//Back Talon in the right transmission ID = 3
	public static final TalonSRX BRSRX = new TalonSRX(3);
	
	//Talon SRX for the shooter motor ID = 4
	public static final TalonSRX Shooter = new TalonSRX(4);
	
	//Talon SR for the climber
	public static final Talon Climber = new Talon(0);
	
	//Talon SR for the front of the intake
	public static final Talon intakeFront = new Talon(1);
	
	//Talon SR for the back of the intake
	public static final Talon intakeBack = new Talon(2);
	
	//Servo for intake hood
	public static final Servo intakeHood = new Servo(3);
	
	//Servo for Gear Mechanism
	public static final Servo gearMechanism = new Servo(4);
	
	//Servo for Hopper Actuation
	public static final Servo Hopper = new Servo(5);
	
	
	
	
		
	
}
