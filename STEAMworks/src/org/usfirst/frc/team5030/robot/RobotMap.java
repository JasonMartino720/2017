package org.usfirst.frc.team5030.robot;


import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.Talon;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Servo;

public class RobotMap 
{
	//Front Talon in the left transmission ID = 0
	
	public static CANTalon FLSRX;
		
		
	//Back Talon in the left transmission ID = 1
		
	public static CANTalon BLSRX;
		
		
	//Front Talon in the right transmission ID = 2
		
	public static CANTalon FRSRX;
		
		
	//Back Talon in the right transmission ID = 3
		
	public static CANTalon BRSRX;
		
		
	//Talon SRX for the shooter motor ID = 4
		
	public static CANTalon Shooter;
	
	//Talon SR for the climber
	public int climber = 0;
	public Talon climberMotor = new Talon(climber);
	
	//Talon SR for the front of the intake
	public int intakefront = 1;
	public Talon intakeFront = new Talon(intakefront);
	
	//Talon SR for the back of the intake
	public int intakeback = 2; 
	public Talon intakeBack = new Talon(intakeback);
	
	//Servo for intake hood
	public static final Servo intakeHood = new Servo(3);
	
	//Servo for Gear Mechanism
	public static final Servo gearMechanism = new Servo(4);
	
	//Servo for Hopper Actuation
	public static final Servo Hopper = new Servo(5);
	
	public RobotMap()
	{
		FLSRX = new CANTalon(0);
		BLSRX = new CANTalon(1);
		FRSRX = new CANTalon(2);
		BRSRX = new CANTalon(3);
		Shooter = new CANTalon(4);
	}
	
	
		
	
}
